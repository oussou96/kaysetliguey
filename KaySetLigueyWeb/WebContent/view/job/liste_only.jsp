<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../../header.jsp"></jsp:include>
 	<div class="content">
 		<div class="container-fluid">
          <div class="row">
            <%-- <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Offres emplois</h4>
                  <p class="card-category">Ajouter une nouvelle offre d'emploi</p>
                </div>
                <div class="card-body">
                	<form method="post" action="Job">
	                
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">L'emploi</label>
	                          <input type="text" name="emploi" class="form-control">
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Date d'annonce</label>
	                          <input type="date" name="dateAnnonce" class="form-control">
	                        </div>
	                      </div>
	                    </div>
	                   <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Date fin annonce</label>
	                          <input type="date" name="dateFinAnnonce" class="form-control">
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Description </label>
	                          <input type="text" name="description" class="form-control">
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                           <label class="bmd-label-floating">Domaine</label>
	                          <select name="domaine" class="form-control">
	                          	<option value=""> Choisir le domaine </option>
	                          	<c:forEach items="${domaines }" var="d">
          							<option value="${d.id }">${d.intituleDomaine }</option>
          						</c:forEach>
	                          </select> 
	                        </div>
	                      </div>
	                    </div>
	                    
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Siège</label>
	                          <input type="text" name="lieu" class="form-control">
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Salaire</label>
	                          <input type="number" name="salaire" class="form-control">
	                        </div>
	                      </div>
	                    </div>
	                    
	                    <button type="submit" class="btn btn-success pull-right">Envoyer</button>
	                 </form>
                </div>
              
              </div>
            </div> --%>
            
            
            <div class="col-md-12">
              <div class="card card-plain">
                <div class="card-header card-header-primary">
                  <h4 class="card-title mt-0">Annonces Emplois</h4>
                </div>
                <div class="card-body">
                  <div class="table-responsive">
                    <table class="table table-hover">
                    	<tr>
                    		<th>Identifiant</th>
                    		<th>L'emploi</th>
                    		<th>Date d'annonce</th>
                    		<th>Date fin annonce</th>
                    		<th>Description</th>
                    		<th>Domaine</th>
                    		<th>Siège</th>
                    		<th>Salaire Proposé</th>
                    		<th>Utilisateur</th>
                    		
                    	</tr>
                    	<c:forEach items="${jobs }" var="b">
          					<tr>
          						<td>${b.id }</td>
          						<td>${b.nomJob }</td>
          						<td>${b.dateAnnonce }</td>
          						<td>${b.dateLimit }</td>
          						<td>${b.job_desc }</td>
          						<td>${b.domaine.intituleDomaine } </td>
          						<td>${b.lieu }</td>
          						<td>${b.salaire }</td>
          						<td>${b.user.pNom } ${b.user.nom }</td>
          						
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
<%-- <jsp:include page="../../footer.jsp"></jsp:include> --%>