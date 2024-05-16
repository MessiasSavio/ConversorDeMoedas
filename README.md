# 🌍 Conversor de Moedas

## 📜 Descrição
Este projeto é um Conversor de Moedas que oferece interação textual via console com os usuários. O conversor permite ao usuário escolher entre várias opções de conversões de moedas através de um menu interativo. As taxas de conversão são obtidas dinamicamente por meio de uma API, garantindo dados precisos e em tempo real para uma experiência atualizada e eficaz.

## 🚀 Funcionalidades
- 💬 Interação via console para facilitar o uso.
- 📋 Menu com várias opções de conversões de moedas.
- 🔄 Taxas de conversão dinâmicas obtidas em tempo real através de uma API.

## 🛠️ Requisitos
- ☕ Java 11 ou superior
- 📦 Dependências externas:
  - gson (para manipulação de JSON)

## 🔧 Instalação
Clone o repositório:
```sh
git clone https://github.com/seuusuario/conversor-moedas.git
```

1. Navegue até o diretório do projeto:
```sh
cd conversor-moedas
```
2. Compile o projeto:
```sh
javac -cp lib/gson-2.8.6.jar -d bin src/com/classes/principal/Main.java
```
3. Execute o projeto:
```sh
java -cp bin:lib/gson-2.8.6.jar com.classes.principal.Main
```
## ▶️ Uso
Ao iniciar o conversor de moedas, siga as instruções no console para selecionar a conversão de moeda desejada e ver a taxa de câmbio atual. O menu principal oferece as seguintes opções:

- 💱 Converter Moedas
- 💹 Ver Moedas Disponíveis
- ➕ Cadastrar Uma Moeda
- 🎲 Ver cotação de moeda aleatória em Real (BRL)
- 💲 Ver Cotação do Dólar (USD) em Real (BRL)
- 💰 Ver Cotação do Euro (EUR) em Real (BRL)
-🚪 Sair

## 🗂️ Estrutura do Projeto
```python
conversor-moedas/
│
├── bin/                         # Diretório para arquivos compilados
├── lib/                         # Diretório para bibliotecas externas
│   └── gson-2.8.6.jar           # Biblioteca Gson
├── src/                         # Diretório para código-fonte
│   └── com/
│       └── classes/
│           ├── principal/
│           │   └── Main.java    # Código principal que executa o conversor de moedas
│           ├── valores/
│           │   ├── ArmazenarMoedas.java
│           │   └── Formatacao.java
├── moedas.txt                   # Arquivo com a lista de moedas disponíveis
├── README.md                    # Documentação do projeto
└── ...                          # Outros arquivos e diretórios relevantes
```
## 🌐 API de Conversão de Moedas
As taxas de conversão são obtidas usando uma API de taxa de câmbio. Certifique-se de configurar suas chaves de API, se necessário, conforme descrito na documentação da API abaixo.
- [Exchangerate](https://www.exchangerate-api.com/);

## 🤝 Contribuição
Faça um fork do projeto. Crie uma nova branch:
```sh
git checkout -b minha-nova-funcionalidade
```
Faça suas alterações e commit:
```sh
git commit -am 'Adiciona nova funcionalidade'
```
Envie para o repositório remoto:
```sh
git push origin minha-nova-funcionalidade
```
Abra um pull request.

## 🤭Divirta-se
Espero quue goste do projeto.

## 🔗Conecte-se Comigo!
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/messiassavio/)
[![Gmail](https://img.shields.io/badge/Gmail-333333?style=for-the-badge&logo=gmail&logoColor=red)](emailto:saviochavesadm@gmail.com)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/MessiasSavio)
[![Instagram](https://img.shields.io/badge/-Instagram-%23E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/messias_savio/)
