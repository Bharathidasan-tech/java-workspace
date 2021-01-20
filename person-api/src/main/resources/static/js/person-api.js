/*! Application JS file */
var app = angular.module('crudApp', ['datatables']);
var access_token;
var refresh_token;
app.controller('crudController', function($scope, $http){
	$scope.success = false;
	$scope.error = false;
	$scope.token;	
	const body ='?grant_type=password&username=admin&password=admin';  
	const headers = $http.defaults.headers.common = {  'Authorization': 'Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0' };
		  $scope.getNewToken = function(){
				$http.post('/oauth/token'+body, headers ).success(function(data){
					access_token=data.access_token;						
				});
		  };
		  
					  
	$scope.fetchData = function(){
				if(access_token == undefined)
				{
					$http.post('/oauth/token'+body, headers ).success(function(data){
						access_token=data.access_token;	
						$http.get('/api/person/?access_token='+access_token).success(function(persondata){
							$scope.userData = persondata.person;
						});		
					});
				}else{
					$http.get('/api/person/?access_token='+access_token).success(function(persondata){
						$scope.userData = persondata.person;
					});	
				}

	};

	$scope.openModal = function(){
		var modal_popup = angular.element('#crudmodal');
		modal_popup.modal('show');
	};

	$scope.closeModal = function(){
		var modal_popup = angular.element('#crudmodal');
		$scope.firstName = '';
		$scope.lastName = '';
		$scope.age = '';
		$scope.favouriteColor = '';
		$scope.hobby = '';
		$scope.hidden_id = '';
		$scope.hidden_hobby_id='';
		modal_popup.modal('hide');
	};

	$scope.addData = function(){
		$scope.form_data = {};
		$scope.modalTitle = 'Add Person Details';
		$scope.submit_button = 'Save';
		$scope.openModal();
	};

	$scope.submitForm = function(){
		var actionURL;
		var httpMethod;
		if($scope.hidden_id != undefined && $scope.hidden_id !=''){
			actionURL="/api/person/?access_token="+access_token;
			httpMethod="PUT";
		 
		}else{
			actionURL="/api/person/?access_token="+access_token;
			httpMethod="POST"
			}
		$http({
			method:httpMethod,
			url:actionURL,
			data:{
				'firstName':$scope.firstName, 
				'lastName':$scope.lastName,
				'age':$scope.age,
				'favouriteColor':$scope.favouriteColor,
				'hobby':[{'id':$scope.hidden_hobby_id,'name':$scope.hobby}],
				'action':$scope.submit_button,
				'id':$scope.hidden_id
				}
		}).success(function(data){
			if(data.id == '')
			{
				$scope.success = false;
				$scope.error = true;
				$scope.errorMessage = 'Person has not been added';
			}
			else
			{
				$scope.success = true;
				$scope.error = false;
				$scope.successMessage = 'Person has been added successfully';
				$scope.firstName = '';
				$scope.lastName = '';
				$scope.age = '';
				$scope.favouriteColor = '';
				$scope.hobby = '';
				$scope.hidden_id = '';
				$scope.hidden_hobby_id='';
				$scope.closeModal();
				$scope.fetchData();
			}
		});
	};

	$scope.editPersonDetails = function(id){
		$http({
			method:"GET",
			url:"/api/person/"+id+"?access_token="+access_token,
			data:{'id':id, 
				'action':'fetch_single_data'
					}
		}).success(function(data){
			var hobbyNames='';
			var hobbyId='';
			var hobbyval=data.hobby;
			angular.forEach(hobbyval, function (value, key) { 
				hobbyNames=hobbyNames+value.name+" ";
				hobbyId=hobbyId+value.id+" ";
            }); 		
			$scope.firstName = data.firstName;
			$scope.lastName = data.lastName;
			$scope.age = data.age;
			$scope.favouriteColor = data.favouriteColor;
			$scope.hobby = hobbyNames;
			$scope.hidden_id = id;
			$scope.hidden_hobby_id=hobbyId;
			$scope.modalTitle = 'Edit Person Details';
			$scope.submit_button = 'Edit';
			$scope.openModal();
		});
	};

	$scope.deletePersonDetails = function(id){
		if(confirm("Are you sure you want to delete it?"))
		{
			$http({
				method:"DELETE",
				url:"/api/person/"+id+"?access_token="+access_token,
				data:{'id':id, 'action':'Delete'}
			}).success(function(data){
				$scope.success = true;
				$scope.error = false;
				$scope.successMessage = data.message;
				$scope.fetchData();
			});	
		}
	};

});
