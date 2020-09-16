<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../header.jsp"></jsp:include>
 	<div class="content">
 		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Candidats</h4>
                  <p class="card-category">Ajouter un nouveau candidat</p>
                </div>
                <div class="card-body">
                	<form method="post" action="Demandeur">
	                
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Prénom</label>
	                          <c:if test="${demandeur != null }">
	                          	<input type="hidden" name="id" class="form-control" value='${demandeur.id}'>
	                           </c:if>
	                          <input type="text" name="prenom" class="form-control" value='<c:if test="${demandeur!=null }">${demandeur.pnom } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nom</label>
	                          <input type="text" name="nom" class="form-control" value='<c:if test="${demandeur!=null }">${demandeur.nom } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Age (ans)</label>
	                          <input type="text" name="age" class="form-control" value='<c:if test="${demandeur!=null }">${demandeur.age } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Email</label>
	                          <input type="text" name="mail" class="form-control" value='<c:if test="${demandeur!=null }">${demandeur.email } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                     <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                           <label class="bmd-label-floating">Choisir le sexe</label>
	                          <select name="sexe" class="form-control" value='<c:if test="${demandeur!=null }">${demandeur.sexe } </c:if>'>
	                          	<option value=""> Sexe</option>
          							<option value="male">Homme</option>
          							<option value="female">Femme</option>
          						
	                          </select> 
	                        </div>
	                      </div>
	                    </div>
	                   
	                    <c:if test="${demandeur != null }">
	                     <button type="submit" class="btn btn-success pull-right">Modifier</button>
	                    </c:if>
	                     <c:if test="${demandeur == null }">
	                     <button type="submit" class="btn btn-success pull-right">Enregistrer</button>
	                    </c:if>
	                    
	              
	                 </form>
                </div>
              
              </div>
            </div>
            
            
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0">Liste des candidats</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>Prénom</th>
                    		<th>Nom</th>
                    		<th>Age (ans)</th>
                    		<th>Email</th>
                    		<th>Sexe</th>
                    		<th>Action</th>
                    		<th>Action</th>
                    	</tr>
                    	<c:forEach items="${demandeurs }" var="dmd">
          					<tr>
          						<td>${dmd.id }</td>
          						<td>${dmd.pnom }</td>
          						<td>${dmd.nom }</td>
          						<td>${dmd.age }</td>
          						<td>${dmd.email }</td>
          						<td>${dmd.sexe }</td>
          						<td><a href="Demandeur?action=edit&idD=${dmd.id}">Editer</a ></td>
          						<td><a href="Demandeur?action=delete&idD=${dmd.id}">Supprimer</a ></td>
          					</tr>
          				</c:forEach>
                    </table>
 <ul nav-item active>
        
        <li class="nav-item active <c:if test="${ page == cv }"></c:if> ">
            <a class="nav-link" href="Cv?page=cv"">
              <i class="material-icons">content_paste</i>
              <p>Liste CV</p>
            </a>
          </li>
        </ul>
        
      </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        
<jsp:include page="../../footer.jsp"></jsp:include>