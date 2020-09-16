<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../header.jsp"></jsp:include>
 	<div class="content">
 		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Entreprises</h4>
                  <p class="card-category">Ajouter un entreprise</p>
                </div>
                <div class="card-body">
                	<form method="post" action="Employeur">
	                
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Nom de l'entreprise </label>
	                          <c:if test="${employeur != null }">
	                          	<input type="hidden" name="id" class="form-control" value='${employeur.id}'>
	                           </c:if>
	                          <input type="text" name="entreprise" class="form-control" value='<c:if test="${employeur!=null }">${employeur.nEmp } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Email</label>
	                          <input type="text" name="email" class="form-control" value='<c:if test="${employeur!=null }">${employeur.email } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Adresse</label>
	                          <input type="text" name="adresse" class="form-control" value='<c:if test="${employeur!=null }">${employeur.adresse } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                   <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Site Web</label>
	                          <input type="text" name="site" class="form-control" value='<c:if test="${employeur!=null }">${employeur.siteweb } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                   <c:if test="${employeur != null }">
	                     <button type="submit" class="btn btn-success pull-right">Modifier</button>
	                    </c:if>
	                     <c:if test="${employeur == null }">
	                     <button type="submit" class="btn btn-success pull-right">Enregistrer</button>
	                    </c:if>
	                    
	                    
	                    
	                 </form>
                </div>
              
              </div>
            </div>
            
            
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0">Liste des entreprises</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>Entreprise</th>
                    		<th>Email</th>
                    		<th>Adresse</th>
                    		<th>Site web</th>
                    		<th>Action</th>
                    		<th>Action</th>
                    	</tr>
                    	<c:forEach items="${employeurs }" var="emp">
          					<tr>
          						<td>${emp.id }</td>
          						<td>${emp.nEmp }</td>
          						<td>${emp.email }</td>
          						<td>${emp.adresse }</td>
          						<td>${emp.siteweb }</td>
          						<td><a href="Employeur?action=edit&idE=${emp.id}">Editer</a ></td>
          						<td><a href="Employeur?action=delete&idE=${emp.id}" onclick="if(!confirm('Voulez vous supprimer')) return false;">Supprimer</a></td>
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