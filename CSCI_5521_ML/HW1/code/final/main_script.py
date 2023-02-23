import numpy as np

from Bayes_learning import *
from Bayes_testing import *


# Load data
training_data = np.loadtxt('training_data.txt')
validation_data = np.loadtxt('validation_data.txt')
test_data = np.loadtxt('testing_data.txt')


p1, p2, pc1, pc2 = Bayes_Learning(training_data, validation_data)
error = Bayes_Testing(test_data, p1, p2, pc1, pc2)
print(f"The error rate with the best prior on the test is: {error}")