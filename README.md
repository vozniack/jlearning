# jLearning [![Build Status](https://travis-ci.com/vozniack/jlearning.svg?branch=master)](https://travis-ci.com/vozniack/jlearning)
Computational intelligence Java library

## Neural networks

```java
NeuralNetwork neuralNetwork = FeedforwardNeuralNetwork.builder()
        .structure(Structure.create(StructureType.FEEDFORWARD, true, 2, 4))
        .learning(Learning.create(LearningType.BACKPROPAGATION, 128, 0.1, 1.0, true))
        .build();

neuralNetwork.init();
neuralNetwork.learn(DatasetUtil.create(new File(FILENAME), ";"));
```

## Genetic algorithm

In progress...