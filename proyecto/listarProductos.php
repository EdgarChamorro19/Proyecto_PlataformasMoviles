<?php
include('db.php');

$stmt=$mysql->prepare("SELECT id,Nombre,Cantidad,Categoria,Valor,imagen FROM productos");
$stmt->execute();
$stmt->bind_result($id, $nombre, $cantidad, $categoria, $valor,$imagen);
$productos = array();

while($stmt->fetch()){
        $temp = array(); 
        $temp['id'] = $id; 
        $temp['Nombre'] = $nombre; 
        $temp['Cantidad'] = $cantidad; 
        $temp['Categoria'] = $categoria; 
        $temp['Valor'] = $valor;
        $temp['imagen'] = $imagen;    
        array_push($productos, $temp);
}
echo json_encode($productos); 

/*$array = array();	
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
}*/
?>