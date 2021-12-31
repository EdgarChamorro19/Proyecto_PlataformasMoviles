<?php
    $mysql = new mysqli(
        "localhost",
        "root",
        "",
        "proyecto"
    );
    
    if($mysql->connect_error){
        die("error".$mysql->connect_error);
    }
?>