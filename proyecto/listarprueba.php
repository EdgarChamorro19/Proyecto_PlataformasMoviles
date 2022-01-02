<?php
include('db.php');
$array = array();	
if($resultset=getSQLResultSet("SELECT * FROM productos")){
	
	while ($row = $resultset->fetch_array(MYSQLI_NUM)){
		$e = array();
                $e['id'] = $row[0];
                $e['Nombre'] = $row[1];
                $e['Cantidad'] = $row[2];
                $e['Categoria'] = $row[3];
                $e['Valor'] = $row[4];
                array_push($array,$e);
	}
        echo json_encode($array);
}
?>