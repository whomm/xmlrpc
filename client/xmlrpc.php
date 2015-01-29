<?php

 
function do_call($host, $port, $request) {

    
                              
    $url = "http://$host:$port/";
    $header[] = "Content-type: text/xml";
    $header[] = "Content-length: ".strlen($request);
    
    $ch = curl_init();   
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_TIMEOUT, 1);
    curl_setopt($ch, CURLOPT_HTTPHEADER, $header);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $request);
    
    $data = curl_exec($ch);       
    if (curl_errno($ch)) {
        return false;
    } else {
        curl_close($ch);
        return $data;
    }
}

$output_options = array(
    "output_type" => "xml",
    "verbosity" => "no_white_spac",
    "escaping" => "markup",
    "version" => "xmlrpc",
    "encoding" => "utf-8"
);

$request = xmlrpc_encode_request('Handler.doRun', array("test string好"),$output_options );
$response = do_call('127.0.0.1',10080, $request);
var_dump($response);
            
