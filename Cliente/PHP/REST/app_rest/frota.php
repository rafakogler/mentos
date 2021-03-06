<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <!-- Mobile support -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
        
     <!-- Material Design fonts -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <!-- Bootstrap -->
  <link href="css/boostrap.min.css" rel="stylesheet">

  <!-- Bootstrap Material Design -->
  <link href="dist/css/bootstrap-material-design.css" rel="stylesheet">
  <link href="dist/css/ripples.min.css" rel="stylesheet">

  <!-- Dropdown.js -->
  <link href="css/jquery.dropdown.css" rel="stylesheet">

  <!-- Page style -->
  <link href="index.css" rel="stylesheet">

  <!-- jQuery -->
  <script src="//code.jquery.com/jquery-1.10.2.min.js"></script>
  
  <link href="https://developers.google.com/maps/documentation/javascript/demos/demos.css" rel="stylesheet">
  
  <script src="http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js" type="text/javascript"></script>
  
        <script id="listaFrota" type="text/x-jquery-tmpl">
            <tr dt-id="${id}"> 
                <th scope="row">1</th> 
                <td>Mark</td> 
                <td>Otto</td> 
                <td>@mdo</td>
                <td>@mdo</td>
                <td>
                    <a style="margin:0px;" class="btn btn-block btn-success">Alterar</a>
                </td>
                <td>
                    <a style="margin:0px;" class="btn btn-block btn-danger">Excluir</a>
                </td>
            </tr>         
        </script>
  
  <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
    </style>
    
    <script src="rest.js"> </script>
    
    <script src="js/frota.js" type="text/javascript"> </script>
      
      <!-- Latest compiled and minified JavaScript -->
      <script src="js/boostrap.min.js" ></script>
    </head>
    <body>
    <div class="modal-content">
      <div class="modal-body">
          <p>Ops, parece que você está <strong>offline</strong>. Algumas tarefas podem não estar sincronizadas com o servidor. <strong> Não feche esta aba. </strong> </p>
      </div>
    </div>
  <div id="delete-dialog" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">Dialog</h4>
        </div>
        <div class="modal-body">
            <p>Você deseja excluir este registro?</p>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary" data-dismiss="modal">Excluir</button>
        </div>
    </div>
  </div>
</div>
        <div id="insert-dialog" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">Cadastro de veículos</h4>
        </div>
        <div class="modal-body">
        </div>
        <div class="modal-footer">
            <div class="form-group has-success ">
                <label for="inputEmail" class="col-md-2 control-label">Placa</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="inputEmail" placeholder="Placa">
                </div>
            </div>
            <div class="form-group has-success">
                <label for="inputEmail" class="col-md-2 control-label">Tipo</label>
                <div class="col-md-8">
                    <div class="btn-group">
                        <a href="javascript:void(0)" class="btn btn-primary btn-raised">Selecione sua viagem<div class="ripple-container"></div></a>
                        <a href="bootstrap-elements.html" data-target="#" class="btn btn-primary btn-raised dropdown-toggle" data-toggle="dropdown"><span class="caret"></span><div class="ripple-container"></div></a>
                        <ul class="dropdown-menu">
                          <li><a href="javascript:void(0)">Auedi Ibirubá - UPF 2017/01</a></li>
                          <li><a href="javascript:void(0)">Auedi Ibirubá - Cruz alta 2017/01</a></li>
                          <li><a href="javascript:void(0)">Auedi Espumoso - UPF 2017/01</a></li>
                          <li class="divider"></li>
                          <li><a href="javascript:void(0)">Separated link</a></li>
                        </ul>
                      </div>                
                </div>
            </div>
            <div class="form-group has-success is-empty">
                <label for="inputEmail" class="col-md-2 control-label">Capacidade</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="inputEmail" placeholder="Placa">
                </div>
            </div>
            <div class="form-group has-success is-empty">
                <label for="inputEmail" class="col-md-2 control-label">Unidades</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="inputEmail" placeholder="Placa">
                </div>
            </div>
        </div>
    </div>
  </div>
</div>
<div id="source-modal" class="modal fade" tabindex="-1">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">Source Code</h4>
      </div>
      <div class="modal-body">
        <pre></pre>
      </div>
    </div>
  </div>
</div>
        <div class="bs-component">
          <div style="font-weight: bold; background-color: #6495ED; box-shadow: 0 0 4px rgba(0,0,0,.14),0 4px 8px rgba(0,0,0,.28);" class="navbar">
            <div class="container-fluid">
                <div class="container">
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-warning-collapse">
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="javascript:void(0)">Brand</a>
              </div>
              <div class="navbar-collapse navbar-warning-collapse collapse in" aria-expanded="true">
                <ul class="nav navbar-nav">
                  <li class="dropdown">
                    <a href="" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Menu
                      <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="javascript:void(0)">Frota</a></li>
                      <li><a href="javascript:void(0)">Mapa em tempo real</a></li>
                      <li><a href="javascript:void(0)">Something else here</a></li>
                      <li class="divider"></li>
                      <li class="dropdown-header">Veja todas as empresas</li>
                      <li><a href="javascript:void(0)">Empresas cadastradas</a></li>
                    </ul>
                  </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                  <li><a href="">Daniel Matheus</a></li>
                    
                  <li class="dropdown">
                    <a href="" data-target="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                      <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="">Action</a></li>
                      <li><a href="">Another action</a></li>
                      <li><a href="">Something else here</a></li>
                      <li class="divider"></li>
                      <li><a href="">Sair</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
          </div>
        </div>
        </div>
            
        <div class="container-fluid main">  
            <div class="col-md-10 col-md-offset-1">
                <div class="col-md-4">   
                </div>
            </div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="well page active" id="getting-started">
                        <div class=" col-md-12">
                            <h1>Bem vindo a mentos!</h1>
                        </div>
                        <h3>Hmm, nada por aqui!</h3>
                    </div>
                </div>
                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">Paniel de Listagem</div>
                            <div class="panel-body"> 
                                <div class="col-md-6">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <a href="javascript:void(0)" class="btn btn-raised btn-info">@<div class="ripple-container"></div></a>   
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="col-md-6">
                                    <div class="form-group">
                                    <div class="dropdown">
                                        <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                          Filtro de tipos
                                          <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                          <li><a href="#">Action</a></li>
                                          <li><a href="#">Another action</a></li>
                                          <li><a href="#">Something else here</a></li>
                                          <li role="separator" class="divider"></li>
                                          <li><a href="#">Separated link</a></li>
                                        </ul>
                                      </div>
                                        
                                    </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <div class="dropdown">
                                            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                              Filtro de tipos
                                              <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                              <li><a href="#">Action</a></li>
                                              <li><a href="#">Another action</a></li>
                                              <li><a href="#">Something else here</a></li>
                                              <li role="separator" class="divider"></li>
                                              <li><a href="#">Separated link</a></li>
                                            </ul>
                                          </div>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                        <table class="table"> 
                            <thead> 
                                <tr>
                                    <th>#</th> 
                                    <th>Placa</th>
                                    <th>Tipo</th>
                                    <th>Capacidade</th>
                                    <th>Outra informação</th>
                                    <th></th>
                                    <th></th>
                                </tr> 
                            </thead> 
                            <tbody> 
                                <tr> 
                                    <th scope="row">1</th> 
                                    <td>Mark</td> 
                                    <td>Otto</td> 
                                    <td>@mdo</td>
                                    <td>@mdo</td>
                                    <td>
                                        <a style="margin:0px; " href="javascript:void(0)" data-toggle="modal" data-target="#insert-dialog" class="btn btn-block btn-success">Alterar</a>
                                    </td>
                                    <td>
                                        <a style="margin:0px; " href="javascript:void(0)" data-toggle="modal" data-target="#delete-dialog" class="btn btn-block btn-danger">Excluir</a>
                                    </td>
                                </tr>
                            </tbody> 
                        </table> 
                    </div>
                </div>
            </div>
        </div>

        </div>
        <div style="position: fixed;" id="box_fab_button">
            <a style="position: relative; z-index: 10;" id="btn_new" href="javascript:void(0)" class="btn btn-primary btn-fab"><i class="material-icons">add</i></a>
        </div>
        <!-- Material Design for Bootstrap -->
        <script src="dist/js/material.js"></script>
        <script src="dist/js/ripples.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function() 
            {
                $.material.init();
            });
        </script>
        
        <script src="//cdnjs.cloudflare.com/ajax/libs/noUiSlider/6.2.0/jquery.nouislider.min.js"></script>
</html>