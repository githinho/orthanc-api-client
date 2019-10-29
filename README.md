[![Build Status](https://travis-ci.org/githinho/orthanc-api-client.svg?branch=master)](https://travis-ci.org/githinho/orthanc-api-client)
[![codecov](https://codecov.io/gh/githinho/orthanc-api-client/branch/master/graph/badge.svg)](https://codecov.io/gh/githinho/orthanc-api-client)
[![Release](https://jitpack.io/v/githinho/orthancAPIClient.svg)](https://jitpack.io/#githinho/orthancAPIClient)
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fgithinho%2Forthanc-api-client.svg?type=shield)](https://app.fossa.io/projects/git%2Bgithub.com%2Fgithinho%2Forthanc-api-client?ref=badge_shield)

# Orthanc API Client in Java
Partly implemented Orthanc API Client written in Java using Retrofit.

## Orthanc
[Orthanc](http://www.orthanc-server.com/) is a open-source, lightweight DICOM server for healthcare and medical research.
[Reference to the Orthanc REST API](https://docs.google.com/spreadsheets/d/1muKHMIb9Br-59wfaQbDeLzAfKYsoWfDSXSmyt6P4EM8/pubhtml?gid=1689572701&single=true). This API Client does not implement all REST API calls.

## Install 
Package managers are supported through [JitPack](https://jitpack.io/#githinho/orthancAPIClient/v0.1) which supports Maven, Gradle, SBT, etc.

For gradle use:
```
    implementation 'com.github.githinho:orthancAPIClient:v0.1'
```

## Usage
For examples see [TestPrint](https://github.com/githinho/orthancAPIClient/blob/master/src/test/java/TestPrint.java).

### Tests
Test are done using [Mock Web Server](https://github.com/square/okhttp/tree/master/mockwebserver). All currently implement REST API calls are tested and covered with tests.

### Future work
Implement and test all Orthanc REST API functionalities. 


## License
[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2Fgithinho%2Forthanc-api-client.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2Fgithinho%2Forthanc-api-client?ref=badge_large)
