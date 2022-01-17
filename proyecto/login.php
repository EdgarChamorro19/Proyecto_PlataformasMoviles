<?php
    require_once("db.php");

    $st_check=$mysql->prepare("SELECT * FROM usuarios WHERE Correo=? AND Password=?");
    $st_check->bind_param("ss",$_POST['Correo'],$_POST['Password']);
    $st_check->execute();
    $rs=$st_check->get_result();

    if ($rs->num_rows==0) {
        echo"Incorrecto";
    }else{
        echo"correcto";
    }
?>


