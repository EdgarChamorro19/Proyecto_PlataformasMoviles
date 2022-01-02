<?php
    require_once("db.php");

    $st_check=$mysql->prepare("INSERT INTO usuarios(Correo,Password,Nombres,Cedula) VALUES (?,?,?,?)");
    $st_check->bind_param("ssss",$_POST['Correo'],$_POST['Password'],$_POST['Nombres'],$_POST['Cedula']);
    $st_check->execute();
    $rs=$st_check->get_result();

    if ($rs->num_rows==0) {
        echo"Incorrecto";
    }else{
        echo"correcto";
    }

?>