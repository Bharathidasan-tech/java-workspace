<!DOCTYPE html>
<html>
	<head>
		<title>Person - Rest API</title>
		<script src="/js/jquery.min.js"></script>
		<script src="/js/angular.min.1.3.15.js"></script>
		<script src="/js/jquery.dataTables.min.js"></script>
		<script src="/js/angular-datatables.min.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="/css/bootstrap.min.css">
		<link rel="stylesheet" href="/css/datatables.bootstrap.css">	
		<script src="/js/person-api.js"></script>	
	</head>
	<body ng-app="crudApp" ng-controller="crudController">
		
		<div class="container" ng-init="fetchData()">	
				<h3 align="center">Person Details - Rest API</h3>	
			<div class="alert alert-success alert-dismissible" ng-show="success" >
				<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
				{{successMessage}}
			</div>
			
			<div class="table-responsive" style="overflow-x: unset;">
			<div align="right">
				<button type="button" name="add_button" ng-click="addData()" class="btn btn-success btn-xs">Add</button>
				<!-- <a href="/api/logout"  class="btn btn-danger btn-xs">Logout</a> -->
			</div>
				<table datatable="ng" dt-options="vm.dtOptions" class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
							<th>Favourite Color</th>
							<th>Hobby</th>
							<th>Edit/Delete</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="name in userData">
							<td>{{name.firstName}}</td>
							<td>{{name.lastName}}</td>
							<td>{{name.age}}</td>
							<td>{{name.favouriteColor}}</td>
							<td>
								<p ng-repeat="hobbyval in name.hobby">				
								{{hobbyval.name}}
								</p>
							</td>
							<td>
								<button type="button" ng-click="editPersonDetails(name.id)" class="btn btn-warning btn-xs">Edit</button>
								<button type="button" ng-click="deletePersonDetails(name.id)" class="btn btn-danger btn-xs">Delete</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</body>
</html>

<div class="modal fade" tabindex="-1" role="dialog" id="crudmodal">
	<div class="modal-dialog" role="document">
    	<div class="modal-content">
    		<form method="post" ng-submit="submitForm()">
	      		<div class="modal-header">
	        		<button type="button" class="close" ng-click="closeModal()" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title">{{modalTitle}}</h4>
	      		</div>
	      		<div class="modal-body">
	      			<div class="alert alert-danger alert-dismissible" ng-show="error" >
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						{{errorMessage}}
					</div>
					<div class="form-group">
						<label>First Name</label>
						<input type="text" name="firstName" ng-model="firstName" class="form-control" required="required" placeholder="Please enter your first name"/>
					</div>
					<div class="form-group">
						<label>Last Name</label>
						<input type="text" name="lastName" ng-model="lastName" class="form-control" required="required" placeholder="Please enter your last name"/>
					</div>
					<div class="form-group">
						<label>Age</label>
						<input type="text"  name="age" ng-model="age" class="form-control" required="required" pattern="[0-9]*" placeholder="Please enter your age"/>
					</div>
					<div class="form-group">
						<label>Favourite Color</label>
						<input type="text" name="favouriteColor" ng-model="favouriteColor" class="form-control"  required="required" placeholder="Please enter your favourite color"/>
					</div>
					<div class="form-group">
						<label>Hobby</label>
						<input type="text" name="hobby" ng-model="hobby" class="form-control"  required="required" placeholder="Please enter a hobby with comma-separated values"/>
					</div>
	      		</div>
	      		<div class="modal-footer">
	      			<input type="hidden" name="hidden_id" value="{{hidden_id}}" />
	      			<input type="hidden" name="hidden_hobby_id" value="{{hidden_hobby_id}}" />
	      			<input type="submit" name="submit" id="submit" class="btn btn-info" value="{{submit_button}}" />
	        		<button type="button" class="btn btn-default" ng-click="closeModal()">Close</button>
	        	</div>
	        </form>
    	</div>
  	</div>
</div>