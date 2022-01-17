<?php

include('db.php');
$stmt=$mysql->prepare("SELECT id,nombrecliente,identificacioncliente,nombreproducto,cantidadproducto,estado,correocliente 
FROM compras");
$stmt->execute();
$stmt->bind_result($id, $nombrec, $idcliente, $nombrepro, $cantidad,$estado, $correo);
$compras = array();

while($stmt->fetch()){
        $temp = array(); 
        $temp['id'] = $id; 
        $temp['nombrecliente'] = $nombrec; 
        $temp['identificacioncliente'] = $idcliente; 
        $temp['nombreproducto'] = $nombrepro; 
        $temp['cantidadproducto'] = $cantidad;
        $temp['estado'] = $estado;
        $temp['correocliente'] = $correo;    
        array_push($compras, $temp);
}
echo json_encode($compras); 