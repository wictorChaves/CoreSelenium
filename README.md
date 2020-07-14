# Core Selenium

Projeto para facilitar a codificação de testes utilizando Selenium.

## Primeiros passos

1 - Crie o seu projeto Maven.
2 - Importe no seu arquivo `pom.xml` a dependência do projeto Core Selenium.

    <dependency>
        <groupId>io.github.wictorchaves</groupId>
        <artifactId>Core</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
    
3 - Crie o arquivo [app.config](docs/app-config.md) na raiz do seu projeto.

## App Config

Arquivo de configuração do projeto.

- [Documentação](docs/app.config)

## Pacotes

### main/java/generate/generate

Gera dados para determinados campos.

Classes:

- CPF - Gerador de CPF.
  
### main/java/generate/helper

Ferramentas para auxílio.

- AppConfig - Utilitário para o app.config.
- File Helper - Utilitário para arquivos.
  
### main/java/generate/selenium

Ferramentas específicas para o Selenium

- Driver - Utilitário de driver.
- Elements - Elementos personalizados.
- Enum - Enum
- Helper - Utilitários para os testes do Selenium.
