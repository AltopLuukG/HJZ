<?PHP
error_reporting(E_ALL);
if ($_SERVER['REQUEST_METHOD'] != 'POST') //Controleer of data via POST wordt verwerkt
{
    $htwpd = file_get_contents(".htpasswd");
    $auth = $_POST["auth"];
    $pass = substr($htwpd, strpos($htpwd, ":") + 1);
    $machine = $_POST["machine"];
    $speed = $_POST["speed"];

    $server = "localhost";
    $connectionInfo = array(
        "Database" => "db001",
        "UID" => "user",
        "PWD" => "password"
    );

    $conn = sqlsrv_connect($server, $connectionInfo);

    if ($conn)
    {

    }


}

echo "kaas";
