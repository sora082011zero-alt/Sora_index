# Sora-index

日本株の市場指数とセクター別データを記録・取得するための Spring Boot API です。

日経平均・TOPIX の履歴、セクターごとの順位・スコア・騰落率、セクター指数の履歴を PostgreSQL に保存できます。セクターの合計スコアやランキングも取得できます。

## 使用技術

- Java 21
- Spring Boot 4.1.0
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## セットアップ

### 1. PostgreSQL を用意する

ローカルに PostgreSQL を起動し、データベースを作成します。

```sql
CREATE DATABASE sora_index;
```

### 2. DB 接続情報を設定する

`src/main/resources/application.properties` を自分の環境に合わせて変更します。

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/sora_index
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

`spring.jpa.hibernate.ddl-auto=update` により、起動時に Entity に合わせてテーブルが更新されます。

### 3. アプリケーションを起動する

Windows:

```bash
./mvnw.cmd spring-boot:run
```

macOS / Linux:

```bash
./mvnw spring-boot:run
```

起動後、API は `http://localhost:8080` で利用できます。

## API

### 市場指数履歴

日経平均と TOPIX の履歴を扱います。

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/market` | 市場指数履歴を全件取得 |
| GET | `/api/market/{id}` | ID を指定して取得 |
| POST | `/api/market` | 市場指数履歴を登録 |

POST 例:

```json
{
  "tradeDate": "2026-06-25",
  "nikkei225": 39600.00,
  "topix": 2800.50
}
```

### セクター履歴

セクターごとの順位、スコア、騰落率を扱います。

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/sectors` | セクター履歴を全件取得 |
| GET | `/api/sectors/{id}` | ID を指定して取得 |
| GET | `/api/sectors/name/{sectorName}` | セクター名で検索 |
| GET | `/api/sectors/date/{tradeDate}` | 日付で検索 |
| GET | `/api/sectors/score/{sectorName}` | セクターの合計スコアを取得 |
| GET | `/api/sectors/ranking` | 合計スコア順のランキングを取得 |
| POST | `/api/sectors` | セクター履歴を登録 |

POST 例:

```json
{
  "tradeDate": "2026-06-25",
  "sectorName": "電気機器",
  "rankNo": 1,
  "score": 10,
  "changeRate": 3.04
}
```

ランキング取得例:

```bash
curl http://localhost:8080/api/sectors/ranking
```

レスポンス例:

```json
[
  {
    "rank": 1,
    "sectorName": "電気機器",
    "totalScore": 25
  }
]
```

### セクター指数履歴

セクター別の指数と騰落率を扱います。

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/api/sector-index` | セクター指数履歴を全件取得 |
| GET | `/api/sector-index/{id}` | ID を指定して取得 |
| POST | `/api/sector-index` | セクター指数履歴を登録 |

POST 例:

```json
{
  "tradeDate": "2026-06-25",
  "sectorName": "電気機器",
  "sectorIndex": 4215.80,
  "changeRate": 3.04
}
```

## テスト

```bash
./mvnw test
```

Windows の場合:

```bash
./mvnw.cmd test
```

## ディレクトリ構成

```text
src/main/java/com/sora/Sora_index
├── Controller   # REST API
├── Entity       # JPA Entity
├── Repository   # Spring Data JPA Repository
├── dto          # レスポンス用 DTO
└── service      # ビジネスロジック
```

## メモ

- 日付は `YYYY-MM-DD` 形式で指定します。
- `id` は DB 登録時に自動採番されます。
- パッケージ名ではハイフンを使えないため、Java パッケージは `com.sora.Sora_index` になっています。
