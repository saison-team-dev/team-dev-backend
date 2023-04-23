# 中国か中国じゃないかアプリ (仮)

台湾と中国の食べ物や文化を題材に、プレイヤーがそれらが台湾のものか中国のものかを判断し知識を試すクイズアプリです。台湾や中国の食べ物や文化が登場し、プレイヤーはそのアイテムが中国のものか台湾のものかを見分けます。プレイヤーはクイズに正解すると、スコアが加算され、ランキング機能を使用することで、自分のスコアを確認することができます。

## 前提条件

以下のソフトウェアのインストールが必要。

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)

## アプリケーションの構築と起動

以下の手順でアプリケーションを構築し、起動します。

1. このリポジトリをクローン。

```bash
$ git clone https://github.com/saison-team-dev/team-dev-backend.git
$ cd team-dev-backend
```

1. Docker Compose を使用して API サーバとデータベースのコンテナを起動。

```bash
$ docker-compose up --build
```

1. ブラウザで [http://localhost:8080](http://localhost:8000/) にアクセスし、アプリケーションが正常に動作していることを確認。

## アプリケーションの停止

アプリケーションとデータベースのコンテナを停止するには、以下のコマンドを実行。

```bash
$ docker-compose down
```
