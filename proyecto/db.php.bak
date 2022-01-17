<?php
    define('DB_HOST', 'localhost');
    define('DB_USER', 'root');
    define('DB_PASS', '');
    define('DB_NAME','proyecto');

    $mysql = new mysqli(
        "localhost",
        "root",
        "",
        "proyecto"
    );
    
    if($mysql->connect_error){
        die("error".$mysql->connect_error);
    }



    function getSQLResultSet($commando) {
        // $mysqli = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);
          $mysqli = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME) or die('unable to connect to db');
         mysqli_set_charset($mysqli, 'utf8');
         /* check connection */
         if ($mysqli->connect_errno) {
             printf("Connect failed: %s\n", $mysqli->connect_error);
             exit();
         }
         if ($mysqli->multi_query($commando)) {
             return $mysqli->store_result();
         }
         $mysqli->close();
     }
?>