# Auth Server

## Schema do banco de dados

Este script cria as tabelas no banco de dados. Note que a tabela **user_auth**
Os scripts de criação das tabelas foram **injetados** na aplicação por meio do **flyway**.
``` Você precisara ajustar as configurações do seu bando e tambem incluir o drive de conexão do banco especifico de seu uso. ```
Caso utilize um banco de dados que não seja o PostgreSQL sera necessario adaptar os scripts de criação de tabelas e de alteração.

#### Criação dos usuários locais.
``` Os ditos usuários locais são para uso em sua aplicação! Ou seja, sua aplicação irá utilizar estas credenciais para conversar com o servidor de autenticação. ```
##### Atenção! Inicialmente já é criado um usuario e uma senha padrão ao inicializar a aplicação.

**Usuário**   | **Senha**
--------- | ------
teste | 123456

```bash
insert into oauth_client_details (client_id, client_secret, "scope", authorized_grant_types, access_token_validity, refresh_token_validity) values ('teste', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', 'read,write', 'password,authorization_code,refresh_token', 15552000, 15552000);

ou

insert into user_auth (login, "password", roles, tenant, active) values ('teste', (SELECT ENCODE(DIGEST('123456','sha512'),'hex')), 'admin', 'teste', true);


```

## Requisição de token

```bash
curl -k -X POST https://teste:123456@auth.datahorizons.info/auth-server/oauth/token -d grant_type=password -d username=teste -d password=123456
```

```bash
curl -X POST http://teste:123456@localhost:8082/auth-server/oauth/token -d grant_type=password -d username=teste -d password=123456
```

## Checagem de token 

```bash
curl -H "Content-Type: application/x-www-form-urlencoded" -X POST http://teste:123456@localhost:8082/auth-server/oauth/check_token?token=fcd11984-fe54-4aff-9a17-4fb62dd541ac

```

## Refresh token

```bash
curl -X POST http://teste:123456@localhost:8082/auth-server/oauth/token -d grant_type=refresh_token -d refresh_token=ba379c76-451d-4691-8514-570cb1e25e83
```
## Invocação com token

```bash
curl -k -H "Content-Type: application/json" -H "Authorization: Bearer 50eff79b-cbcc-4f8a-933c-b5185a248268" --data '{"campo1":3,"campo2":123}' -X POST http://localhost:8080/recurso/context
```
 

## Criar usuário

```bash
curl -X POST http://teste_user:123456@localhost:8082/auth-server/manager -d '{"login":"teste_user1@M.Com","password":"123456","roles":["ROLE_VIEWER"],"tenant":"teste"}' -H "Content-Type: application/json"
```

## Modificar senha

```bash
 curl -X POST http://teste_user:123456@localhost:8082/auth-server/manager/change -d '{"login":"teste_user1@M.Com","actual":"123456","newPass":"teste"}' -H "Content-Type: application/json"
```
