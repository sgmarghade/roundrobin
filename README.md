# RoundRobin data retrieval.

Simple wrapper using queue for getting data in round robbin way.

You can shuffle objects using constructor value  shuffleObjects = true;

Implementation is 100% thread safe and ordering of round robbin is guaranteed.


## Usage :-

RoundRobinService service = new RoundRobinService(list,false);

YourDataType object = service.getNextObject();


