# Flight Ticket Management System

 ###### This application includes these flight ticketing backend services:
 - Airline (Create,Read,Delete)
 - Airport (Create,Read,Delete)
 - Route (Create,Read,Delete)
 - Flight (Create,Read,Delete)
 - Ticket (Create,Read,Delete)

### Tech Stack

  - Java 8
  - Maven
  - Spring Boot
  - PostgreSQL

### To run

  - This repository can be imported as Maven project and run on your local IDE.
  - You can also access running application on AWS: [linkAWS]
  - Docker hub: [xbersoy] (can be pulled on cli : docker pull burakersoy/ticketingsystem:latest)
  
   
### Service Documentation 

#### Note : This application does not store plane, customer entities. Columns related to these (like customer first name, last name or plane seat number, totals seats) stored in another object instead.

##### - Airline
 -- GET (By ID) : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/airlines/{id}

   - Sample Request Payload : - 
   - Sample Response Payload : 
    {
        "id": 1,
        "name": "THY"
    }

 -- POST : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/airlines

   - Sample Request Payload : 
    {
        "name": "THY"
    }

   - Sample Response Payload : 
    {
        "id": 1,
        "name": "THY"
    }
 
-- DELETE : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/airlines/{id}

   - Sample Request Payload : -
   - Sample Response Payload : -

##### - Airport

 -- GET (By ID) : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/airports/{id}

   - Sample Request Payload : -
   - Sample Response Payload : 
   {"id": 2,
    “name”: “SabihaGokcen”,
    “city”:“Istanbul”,
    “alias”: “SAW”
    }

 -- POST : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/airports

   - Sample Request Payload : 
    {
	"name": "SabihaGokcen",
	"city":"Istanbul",
	"alias": "SAW"
    }
   - Sample Response Payload : 
    {
    "id": 2,
    "name": "SabihaGokcen",
    "city": "Istanbul",
    "alias": "SAW"
}

-- DELETE : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/airports/{id}

   - Sample Request Payload : - 
   - Sample Response Payload : -

##### - Route

 -- GET (By ID) :  http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/routes/{id}

   - Sample Request Payload : -
   - Sample Response Payload : 
   {
    "id": 1,
    "airportTo": {
        "id": 1,
        "name": "Ataturk",
        "city": "Istanbul",
        "alias": "IST"
    },
    "airportFrom": {
        "id": 2,
        "name": "SabihaGokcen",
        "city": "Istanbul",
        "alias": "SAW"
    }
}

 -- POST : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/routes
 
  - Sample Request Payload :
  {
"airportFrom": {
    "id": 2,
    "name": "SabihaGokcen",
    "city": "Istanbul",
    "alias": "SAW"
},
"airportTo": {
    "id": 1,
    "name": "Ataturk",
    "city": "Istanbul",
    "alias": "IST"
}
}
   - Sample Response Payload : 
   {
    "id": 1,
    "airportTo": {
        "id": 1,
        "name": "Ataturk",
        "city": "Istanbul",
        "alias": "IST"
    },
    "airportFrom": {
        "id": 2,
        "name": "SabihaGokcen",
        "city": "Istanbul",
        "alias": "SAW"
    }
}

 -- DELETE :  http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/routes/{id}

   - Sample Request Payload : - 
   - Sample Response Payload : - 

##### - Flight

 -- GET (By ID) : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/flights/{id}

   - Sample Request Payload : - 
   - Sample Response Payload :
   {
    "id": 1,
    "flightCode": "TK1101",
    "airline": {
        "id": 1,
        "name": "THY"
    },
    "route": {
        "id": 1,
        "airportTo": {
            "id": 1,
            "name": "Ataturk",
            "city": "Istanbul",
            "alias": "IST"
        },
        "airportFrom": {
            "id": 2,
            "name": "SabihaGokcen",
            "city": "Istanbul",
            "alias": "SAW"
        }
    },
    "totalSeat": 100,
    "availableSeat": 100,
    "departureDate": "2019-12-12",
    "arrivalDate": "2019-12-12"
}
 
-- POST : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/flights

NOTE:
> Default total seat is set 100 for every each flight.
> Available seat data is also stored in flight table
> On every  transaction on ticket entity related flight entity updates
 
  - Sample Request Payload : 
  {
	"flightCode": "TK1101",
	"route" :{
    "id": 1,
    "airportTo": {
        "id": 1,
        "name": "Ataturk",
        "city": "Istanbul",
        "alias": "IST"
    },
    "airportFrom": {
        "id": 2,
        "name": "SabihaGokcen",
        "city": "Istanbul",
        "alias": "SAW"
    }
},
	"airline" : {
    "id": 1,
    "name": "THY"
},
	"departureDate": "2019-12-12",
	"arrivalDate": "2019-12-12"

}
  
   - Sample Response Payload :
   {
    "id": 1,
    "flightCode": "TK1101",
    "airline": {
        "id": 1,
        "name": "THY"
    },
    "route": {
        "id": 1,
        "airportTo": {
            "id": 1,
            "name": "Ataturk",
            "city": "Istanbul",
            "alias": "IST"
        },
        "airportFrom": {
            "id": 2,
            "name": "SabihaGokcen",
            "city": "Istanbul",
            "alias": "SAW"
        }
    },
    "totalSeat": 100,
    "availableSeat": 100,
    "departureDate": "2019-12-12",
    "arrivalDate": "2019-12-12"
}

 -- DELETE : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/flights/{id}
 
  - Sample Request Payload : -
   - Sample Response Payload : -
   
##### - Ticket

NOTE:
> Default ticket price is set as 100.00
> and default available seat is set 100 for every each flight.
> After post request to ticket entity, available seat decreases 1
> on delete ticket increases 1


| Sold Tickets | Price |
| ------ | --------------- |
| 0 - 10 | 100 (Min) |
| 10 - 20 | 110 |
| 20 - 30 | 120 |
| 30 - 40 | 130 |
| 40 - 50 | 140 |
| 50 - 60 | 150 |
| 60 - 70 | 160 |
| 70 - 80 | 170 |
| 80 - 90 | 180 |
| 90 - 100 | 190 (Max) |

-- GET (By ID) : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/tickets/{id}
 
  - Sample Request Payload :  - 
   - Sample Response Payload :
   {
    "id": 1,
    "flight": {
    "id": 1,
    "flightCode": "TK1101",
    "airline": {
        "id": 1,
        "name": "THY"
    },
    "route": {
        "id": 1,
        "airportTo": {
            "id": 1,
            "name": "Ataturk",
            "city": "Istanbul",
            "alias": "IST"
        },
        "airportFrom": {
            "id": 2,
            "name": "SabihaGokcen",
            "city": "Istanbul",
            "alias": "SAW"
        }
    },
    "totalSeat": 100,
    "availableSeat": 100,
    "departureDate": "2019-12-12",
    "arrivalDate": "2019-12-12"
},
    "seatNumber": "22F",
    "passengerIdNumber": "12345678902"
}
 
-- POST : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/tickets
 
  - Sample Request Payload : 
  {
    "flight": {
    "id": 1,
    "flightCode": "TK1101",
    "airline": {
        "id": 1,
        "name": "THY"
    },
    "route": {
        "id": 1,
        "airportTo": {
            "id": 1,
            "name": "Ataturk",
            "city": "Istanbul",
            "alias": "IST"
        },
        "airportFrom": {
            "id": 2,
            "name": "SabihaGokcen",
            "city": "Istanbul",
            "alias": "SAW"
        }
    },
    "totalSeat": 100,
    "availableSeat": 100,
    "departureDate": "2019-12-12",
    "arrivalDate": "2019-12-12"
},
    "seatNumber": "22F",
    "passengerIdNumber": "12345678902"
}
   - Sample Response Payload :
   {
    "id": 1,
    "flight": {
    "id": 1,
    "flightCode": "TK1101",
    "airline": {
        "id": 1,
        "name": "THY"
    },
    "route": {
        "id": 1,
        "airportTo": {
            "id": 1,
            "name": "Ataturk",
            "city": "Istanbul",
            "alias": "IST"
        },
        "airportFrom": {
            "id": 2,
            "name": "SabihaGokcen",
            "city": "Istanbul",
            "alias": "SAW"
        }
    },
    "totalSeat": 100,
    "availableSeat": 100,
    "departureDate": "2019-12-12",
    "arrivalDate": "2019-12-12"
},
    "seatNumber": "22F",
    "passengerIdNumber": "12345678902"
}
 
-- DELETE : http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000/tickets/{id}
 
  - Sample Request Payload : -
   - Sample Response Payload : -


### Todos

 - Write MORE Tests



   [linkAWS]: <http://ec2-18-191-29-198.us-east-2.compute.amazonaws.com:5000>
   [xbersoyDockerHub]: <https://hub.docker.com/repository/docker/burakersoy/ticketingystem>
