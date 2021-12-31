<?php 
	
	//adding dboperation file 
	require_once '../DbOperation.php';
	
	//response array 
	$response = array(); 
	
	if (empty($_POST['cedula']) && empty($_POST['nombre'])) {
      $response['error'] = true; 
      $response['message'] = 'Campos Vacios al enviar los datos';

   } else {
      if (isset($_POST['cedula']) && isset($_POST['nombre'])) {
         $db = new DbOperation(); 
         if($db->insertUser($_POST['cedula'], $_POST['nombre'])){
            $response['error'] = false;
            $response['message'] = 'Usuario agregado con exito';
         }else{
            $response['error'] = true;
            $response['message'] = 'No se puede agregar el usuario';
         }
         // }else{
         // 	$response['error'] = true; 
         // 	$response['message'] = 'Required Parameters are missing';
         // }	
      }else{
         $response['error'] = true; 
         $response['message'] = 'Invalido Request';
      }

   }
	
	//displaying the data in json 
   echo json_encode($response);
?>