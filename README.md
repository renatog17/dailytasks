# README EM CONSTRUÇÃO

🚀Tests de integração em um CRUD feito em Spring e Java utilizando um profile de testes e um banco também de testes, o H2 🧪💻.

👇Segue o algoritmo para escrever o algoritmo que vai testar o seu algoritmo:

1️⃣ Configure o profile de testes, como vc vai fazer isso?🤔 Basta criar o arquivo https://lnkd.in/ddKJ5g4a para criar o profile de testes.
🔗Aqui está um exemplo: https://lnkd.in/dbeq2Aa5

2️⃣ Adicione as dependências necessárias:
Aqui o pom: 
📂https://lnkd.in/dxhiynaD
⚠️Obs.: este pom já vem configurado se você utilizar o Spring Initializrr. 🚀

3️⃣ Crie uma classe para conter os métodos de testes 📋, você terá de a anotar com as seguintes configurações:
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
📄Que podem ser acessadas aqui: https://lnkd.in/das3hZBJ

4️⃣ Use MockMvcRequestBuilders para simular as requisições.  🛠️  Usar essa classe é como se você estivesse abrindo o postman ou o insomnia para enviar uma requisição. E, como diz o ditado popular, onde há request, há result, não esqueça de usar MockMvcResultMatchers também ✅.

📦Aqui o projeto completo: https://lnkd.in/dthC6xRm
