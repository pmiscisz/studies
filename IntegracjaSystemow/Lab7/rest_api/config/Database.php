<?php
class Database
{
    
    private $host = 'db';
    private $user = 'root';
    private $password = "1234";
    private $database = "world";
    {
        $conn = new mysqli($this->host, $this->user, $this->password, $this->database);
        if ($conn->connect_error) {
            die("Error failed to connect to MySQL: " .
                $conn->connect_error);
        } else {
            return $conn;
        }
    }
}