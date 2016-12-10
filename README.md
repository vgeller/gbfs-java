# gbfs-java

Java API for accessing GBFS (General Bikeshare Feed Specification) feeds

##Build Status
[![Build Status](https://travis-ci.org/vgeller/gbfs-java.svg?branch=master)](https://travis-ci.org/vgeller/gbfs-java)

##Example Usage

```java
final Gbfs gbfs = new Gbfs("https://gbfs.citibikenyc.com/gbfs/gbfs.json");
final List<StationStatus> stationStatusList = gbfs.getStationStatusList();
final List<StationInfo> stationInfoList = gbfs.getStationInfoList();
```