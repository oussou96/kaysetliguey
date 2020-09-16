<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <link rel="apple-touch-icon" sizes="76x76" href="public/template/assets/img/apple-icon.png">
  <link rel="icon" type="image/png" href="public/assets/img/favicon.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <title>
   Kay Set Liguey - Plateforme de Recherche d'emploi
  </title>
  <meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
  <!-- CSS Files -->
  <link href="public/template/assets/css/material-dashboard.css?v=2.1.2" rel="stylesheet" />
  <!-- CSS Just for demo purpose, don't include it in your project -->
  <link href="public/template/assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="">
  <div class="wrapper ">
    <div class="sidebar" data-color="purple" data-background-color="white" data-image="public/assets/img/sidebar-1.jpg">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
      <div class="logo"><img src="public/template/assets/img/ksl.png" style="width:70%;margin-left:5px;" alt="logoKsl" class="simple-text logo-normal"/></div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="nav-item  ">
            <a class="nav-link" href="http://localhost:8080/KaySetLigueyWeb/Welcome">
              <i class="material-icons">dashboard</i>
              <p>Tableau de bord</p>
            </a>
          </li>
          <%-- <li class="nav-item <c:if test="${ page == utilisateur }"></c:if>">
            <a class="nav-link" href="Utilisateur?page=utilisateurs">
              <i class="material-icons">Person</i>
              <p>Profile utilisateur</p>
            </a>
          </li> --%>
          
           <li class="nav-item active <c:if test="${ page == job }"></c:if>">
            <a class="nav-link" href="Job?page=offres_emplois">
              <i class="material-icons">work</i>
              <p>Offres d'emplois</p>
            </a>
          </li>
           <li class="nav-item active <c:if test="${ page == employeur }"></c:if>">
            <a class="nav-link" href="Employeur?page=employeurs">
              <i class="material-icons">group</i>
              <p>Entreprises</p>
            </a>
          </li>
          
            <li class="nav-item active <c:if test="${ page == demandeur }"></c:if> ">
            <a class="nav-link" href="Demandeur?page=demandeurs">
              <i class="material-icons">person</i>
              <p>Candidats</p>
            </a>
          </li>
          
          <li class="nav-item active <c:if test="${ page == domaine }"></c:if> ">
            <a class="nav-link" href="Domaine?page=domaines">
              <i class="material-icons">content_paste</i>
              <p>Domaines professionels</p>
            </a>
          </li>
          
          
         
           <li class="nav-item active <c:if test="${ page == utilisateur}"></c:if>">
            <a class="nav-link" href="Utilisateur?page=users">
              <i class="material-icons">person</i>
              <p>Administration</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <a class="navbar-brand" href="javascript:;"></a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
            <span class="navbar-toggler-icon icon-bar"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end">
            <form class="navbar-form">
              <div class="input-group no-border">
                <input type="text" value="" class="form-control" placeholder="Search...">
                <button type="submit" class="btn btn-white btn-round btn-just-icon">
                  <i class="material-icons">search</i>
                  <div class="ripple-container"></div>
                </button>
              </div>
            </form>
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link" href="javascript:;">
                  <i class="material-icons">dashboard</i>
                  <p class="d-lg-none d-md-block">
                    Stats
                  </p>
                </a>
              </li>
             
              <li class="nav-item dropdown">
                <a class="nav-link" href="javascript:;" id="navbarDropdownProfile" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <i class="material-icons">person</i>
                  <p class="d-lg-none d-md-block">
                    Account
                  </p>
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownProfile">
                <a class="dropdown-item" href="#">${user.pNom } ${user.nom } </a>
                  <a class="dropdown-item" href="#">Profile</a>
                  <a class="dropdown-item" href="#">Paramètres</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="Logout">Se déconnecter</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <!-- End Navbar -->