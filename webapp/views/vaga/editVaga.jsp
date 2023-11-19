<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
   <link rel="stylesheet" type="text/css" href="./assets/css/index.css"/>
 <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
<title>Trampo 360::Atualizar Aluno</title>     
    
</head>


<body>
<nav class="navbar">
    <div class="container-fluid">
      <h1> Bora Agora?</h1>
      <a class="navbar-brand" href="#">Deixa conosco o planejamento!</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a href="index.html" class="nav-link active" aria-current="page">Home</a>
          </li>
          <li class="nav-item">
            <a href="promocao.html" class="nav-link" aria-current="page">Promoções</a>
          </li>
          <li class="nav-item">
            <a href="destino.html" class="nav-link" aria-current="page">Destinos</a>
          </li>
          <li class="nav-item">
            <a href="contato.html" class="nav-link" aria-current="page">Contato</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Login
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="entrar.html">Entrar</a></li>
              <li><a class="dropdown-item" href="cadastro.html">Cadastre-se</a></li>
             </ul>
          </li>
    </ul>
        
        <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Pesquisar</button>
        </form>
      </div>
    </div>
  </nav>
  
        <header class="tag">
            <h1 class="container">Atualizar Inscrições de Vagas</h1>
        </header>
        
<main>
       <div class="container py-3">
            <form action="./vaga-update">
            <input type="hidden" id="id_Vaga" name="id_Vaga" class="form-control" value="${vaga.id_Vaga}" />

	            <div class="form-group mb-3">
                        <label for="data_Vaga" class="form-label">
                           Data da inscrição da vaga.
                        </label>
                        <input type="text" id="data_Vaga" name="data_Vaga" class="form-control" placeholder="Insira a data da vaga" value="${vaga.data_Vaga}" />
                    </div>
                    
                     <div class="form-group mb-3">
                        <label for="Nome" class="form-label">
                            Nome
                        </label>
                        <input type="text" id="nome" name="nome"
                         class="form-control" placeholder="Insira o nome" value="${vaga.nome}"/>
                    </div>
                    

                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./aluno" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
               
            </form>
        </div>
       </main>

    <footer>
        <div class="footer-info">
            <div class="contact-info">

                <h5>Telefone para contato</h5>
                </p>
                <p> (11) 3858-0777 </p>
                <p> (11) 97770-3952</p>
            </div>
            <div class="end-info">
                <h5>Endereço</h5>
                <p>Rua Gaivota, 125 - Bairro Moema</p>
                <p> São Paulo - SP</p>
            </div>
            <div class="social-media text-white">
                <h5> Nossas mídias sociais</h5>
                <i class="bi bi-instagram insta fs-4" onclick="window.open('https://www.instagram.com/', '_blank')"></i>
                <i class="bi bi-facebook face fs-4" onclick="window.open('https://www.facebook.com/', '_blank')"></i>
                <i class="bi bi-twitter tw fs-4" onclick="window.open('https://www.twitter.com/', '_blank')"></i>
                <i class="bi bi-messenger mess fs-4" onclick="window.open('https://www.messenger.com/', '_blank')"></i>
                <i class="bi bi-whatsapp whats fs-4 " onclick="window.open('https://web.whatsapp.com/', '_blank')"></i>
            </div>
        </div>
        <div class="footer-text">
            <p>&copy; 2023 Trampo360°. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!---fimRodapé-->
</main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>

</html>