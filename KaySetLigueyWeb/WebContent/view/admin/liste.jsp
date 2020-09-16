<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../header.jsp"></jsp:include>
 	<div class="content">
 		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Administration</h4>
                  <p class="card-category">Ajouter un nouveau utilisateur</p>
                </div>
                <div class="card-body">
                	<form method="post" action="Utilisateur">
	                
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Prénom ou nom de l'entreprise</label>
	                          <c:if test="${user != null }">
	                          	<input type="hidden" name="id" class="form-control" value='${user.id}'>
	                           </c:if>
	                          <input type="text" name="prenom" class="form-control" value='<c:if test="${user!=null}"> ${user.pNom}</c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nom ou slogan de l'entreprise</label>
	                          <input type="text" name="nom" class="form-control" value='<c:if test="${user!=null}"> ${user.nom}</c:if>'>
	                        </div>
	                      </div>
	                    </div>
	              
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Email</label>
	                          <input type="text" name="email" class="form-control" value='<c:if test="${user!=null}"> ${user.email}</c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                      <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Mot de passe</label>
	                          <input type="password" name="mdp" class="form-control" value='<c:if test="${user!=null}"> ${user.mdp}</c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                     <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                           <label class="bmd-label-floating">Choisir le profil</label>
	                          <select name="profil" class="form-control" value='<c:if test="${user!=null}"> ${user.profil}</c:if>'>
	                          	<option value=""> </option>
          							<option value="demandeur">Candidat au poste</option>
          							<option value="employeur">Entreprise </option>
          						
	                          </select> 
	                        </div>
	                      </div>
	                    </div>
							<c:if test="${user != null }">
	                     <button type="submit" class="btn btn-success pull-right">Modifier</button>
	                    </c:if>
	                     <c:if test="${user == null }">
	                     <button type="submit" class="btn btn-success pull-right">Enregistrer</button>
	                    </c:if>
	                 </form>
                </div>
              
              </div>
            </div>
            
            
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0">Liste des utilisateurs</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>Prénom ou de l'entreprise</th>
                    		<th>Nom ou Slogan de l'entreprise</th>
                    		<th>Email</th>
                    		<th>profil</th>
                    		<th>Action</th>
                    		<th>Action</th>
                    	</tr>
                    	<c:forEach items="${users}" var="u">
          					<tr>
          						<td>${u.id }</td>
          						<td>${u.pNom }</td>
          						<td>${u.nom }</td>
          						<td>${u.email }</td>
          						<td>${u.profil }</td>
          						<td><a href="Utilisateur?action=edit&idU=${u.id}">Editer</a ></td>
          						<td><a href="Utilisateur?action=delete&idU=${u.id}">Supprimer</a ></td>
          					</tr>
          				</c:forEach>
                    </table>
 
        
      </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
<jsp:include page="../../footer.jsp"></jsp:include>