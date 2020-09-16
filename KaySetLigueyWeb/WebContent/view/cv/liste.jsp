<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../../header.jsp"></jsp:include>
 	<div class="content">
 		<div class="container-fluid">
          <div class="row">
            <div class="col-md-12">
              <div class="card">
                <div class="card-header card-header-primary">
                  <h4 class="card-title">Cv</h4>
                  <p class="card-category">Ajouter un CV</p>
                </div>
                <div class="card-body">
                	<form method="post" action="Cv">
	                
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                        	<label class="bmd-label-floating">Expérience professionelle</label>
	                        	<c:if test="${cv != null }">
	                          	<input type="hidden" name="id" class="form-control" value='${cv.id}'>
	                           </c:if>
	                        	<%-- <textarea name="exp_pro" class="form-control" value='<c:if test="${cv!=null }"> ${cv.expPro }</c:if>'></textarea> --%>
	                        	<input type="text" name="exp_pro" class="form-control" value='<c:if test="${cv!=null }"> ${cv.expPro }</c:if>'>
	                         
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Niveau d'étude</label>
	                          <input type="text" name="niv_etud" class="form-control" value='<c:if test="${cv!=null }"> ${cv.nivEtude }</c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                          <label class="bmd-label-floating">Téléphone Pro</label>
	                          <input type="tel" name="tel_pro" class="form-control" value='<c:if test="${cv!=null }"> ${cv.telPro }</c:if>'>
	                        </div>
	                      </div>
	                    </div>
	                    <div class="row">
	                      <div class="col-md-12">
	                        <div class="form-group">
	                           <label class="bmd-label-floating">Proprio Cv</label>
	                          <select name="demandeur" class="form-control" value='<c:if test="${cv!=null }"><%-- ${cv.demandeur }  --%></c:if>'>
	                          	<option value=""> Choisir le candidat </option>
	                          	<c:forEach items="${demandeurs }" var="dmd">
          							<option value="${dmd.id }">${dmd.pnom }  ${dmd.nom }</option>
          						</c:forEach>
	                          </select> 
	                        </div>
	                      </div>
	                    </div>
	                    
	                    <c:if test="${cv != null }">
	                     <button type="submit" class="btn btn-success pull-right">Modifier</button>
	                    </c:if>
	                     <c:if test="${cv == null }">
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
                    		<th>Expérience professionelle</th>
                    		<th>Niveau d'étude</th>
                    		<th>Tel. pro</th>
                    		<th>Propio CV</th>
                    		<th>Action</th>
                    		<th>Action</th>
                    	</tr>
                    	<c:forEach items="${cvs }" var="cv">
          					<tr>
          						<td>${cv.id }</td>
          						<td>${cv.expPro }</td>
          						<td>${cv.nivEtude }</td>
          						<td>${cv.telPro }</td>
          						<td>${cv.demandeur.pnom } ${cv.demandeur.nom }</td>
          						<td><a href="Cv?action=edit&idCv=${cv.id}">Editer</a ></td>
          						<td><a href="Cv?action=delete&idCv=${cv.id}">Supprimer</a ></td>
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