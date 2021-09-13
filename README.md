# gateway-spring

simple demo for creating server side gateway deivces 

# instruction for installing the program 

# first open db_scripts and follow setps 
# step 01: create users 
# step 02 : create schema and tables 

* user name , password , schema name should be used in spring properties file, take notes before changing it.

schema and table sql script has both structure of gateway table and device table , and has many to one relation between device and gateway 


* the spring program use java 11 

# to run the program "gateway-manager/src/main/java/ghareeb/gatewaymanager/GatewayManagerApplication.java"

the program has:
* config for exposing id 
* Rest controller for posting and request JsonBody 
* JPA (data access Object) for device and gatway entites 
* DTO (Data transfer Object) to get Json body and response Message 
* entity for Gateway and Device 
* validation pattern for IP-V4 Address 
* java persistance (relations) between entities 
* service layer 
* conditionals to determine how to post objects in database based on certain condition 

# use postman client to make http method request 
# use Json example from Json-example folder 

End point for get 
http://localhost:8080/api 

gateways endpoint: 
http://localhost:8080/api/gateways

devices endpoint : 
http://localhost:8080/api/devices


End point for post 
POST : localhost:8080/api/add 

Post Cases : 

1-> save Gateways without devices 

BODY : 

{
    "gateways" : {
        "name" : "HG5007",
        "ipAddress": "192.168.1.2"
    }
}



2 -> save Gateways with its Devices 

BODY : 

{
    "gateways" : {
        "name" : "HG5007",
        "ipAddress": "192.168.1.2"
    }, 
    "devices" : [
        {
            "vendor" : "wifi",
            "status" : true
        },
        {
            "vendor" : "ethernet",
            "status" : false
        }
    ]
}

3 -> save gateway with devices that related to another gateway 

BODY :

{
    "gateways" : {
        "name" : "HG5007",
        "ipAddress": "192.168.1.2"
    }, 
    "devices" : [
        {
            "vendor" : "wifi",
            "status" : true,
            "gateways" : { "id" : 19 }
        },
        {
            "vendor" : "ethernet",
            "status" : false,
            "gateways" : {"id" : 18}
        }
    ]
}

4 -> save 2 devices one for gateway object in the body , second device for gateway already exist in the database

BODY :

{
    "gateways" : {
        "name" : "HG5007",
        "ipAddress": "192.168.1.2"
    }, 
    "devices" : [
        {
            "vendor" : "wifi",
            "status" : true
        },
        {
            "vendor" : "ethernet",
            "status" : false,
            "gateways" : {"id" : 18}
        }
    ]
}



5 -> save devices only that related to existing gateway 

BODY :

{
    "devices" : [
        {
            "vendor" : "wifi",
            "status" : true,
            "gateways" : { "id" : 19 }
        },
        {
            "vendor" : "ethernet",
            "status" : false,
            "gateways" : {"id" : 18}
        }
    ]
}




