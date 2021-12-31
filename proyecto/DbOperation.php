<?php
 
class DbOperation
{
    private $con;
 
    function __construct()
    {
        require_once dirname(__FILE__) . '/DbConnect.php';
        $db = new DbConnect();
        $this->con = $db->connect();
    }
 
	//adding a record to database 
	public function insertUser($cedula, $nombre){
		$stmt = $this->con->prepare("INSERT INTO cliente(cedula, nombre) VALUES ('$cedula', '$nombre')");
		//$stmt->bind_param("sssss", $Cedula,$Nombre, $Apellido, $Edad, $Sexo);
		if($stmt->execute())
			return true; 
		return false; 
	} 

	//fetching all records from the database 
}