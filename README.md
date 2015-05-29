# RoundRobin data retrieval.

Simple wrapper using queue for getting data in round robbin way.

Implementation is 100% thread safe and ordering of round robbin is guaranteed.


## Usage :-

RoundRobinService service = new RoundRobinService(list);

YourDataType object = service.getNextObject();