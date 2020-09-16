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
                  <h4 class="card-title">Domaines</h4>
                  <p class="card-category">Ajouter un domaine</p>
                </div>
                <div class="card-body">
                	<form method="post" action="Domaine">
	                
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Libelle domaine</label>
	                          <c:if test="${domaine != null }">
	                          	<input type="hidden" name="id" class="form-control" value='${domaine.id}'>
	                           </c:if>
	                          <input type="text" name="domaine" class="form-control" value='<c:if test="${domaine!=null }">${domaine.intituleDomaine } </c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                     <c:if test="${domaine != null }">
	                     <button type="submit" class="btn btn-success pull-right">Modifier</button>
	                    </c:if>
	                     <c:if test="${domaine == null }">
	                     <button type="submit" class="btn btn-success pull-right">Enregistrer</button>
	                    </c:if>
	                    
	                 </form>
                </div>
              
              </div>
            </div>
            
            
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0">Liste des domaines</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>Libelle domaine</th>
                    		<th>Action</th>
                    		<th>Action</th>
                    	</tr>
                    	<c:forEach items="${domaines }" var="d">
          					<tr>
          						<td>${d.id }</td>
          						<td>${d.intituleDomaine }</td>
          						<td><a href="Domaine?action=edit&idDom=${d.id}">Editer</a ></td>
          						<td><a href="Domaine?action=delete&idDom=${d.id}" onclick="if(!confirm('Voulez vous supprimer')) return false;">Supprimer</a></td>
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