## Getting started

This application facilitates the booking and return of phones by users.

## Requirements

-   Docker runtime installed on your computer

## Installation

From the root directory of the project, execute the following commands:

    docker build -t phone-booking-app .
    docker run -it phone-booking-app

## Usage

To book phone for testing, for example IPHONE_X by User, enter the following command in the command line:

    book IPHONE_X User

To return the phone back, enter the following command:

    return IPHONE_X

To exit the application, enter the following command:

    quit