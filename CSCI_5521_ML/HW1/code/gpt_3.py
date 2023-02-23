
#This script first loads the training, validation, and test data using numpy.loadtxt(). 
# It then calls the Bayes_Learning() function from Bayes_learning.py to get the learned parameters and best priors for the classification problem.
#  The error rates for each value of sigma are stored in the error_rates variable and printed to the console in a table.

#Finally, the script calls the Bayes_Testing() function from Bayes_testing.py to get the error rate on the test data, and prints the result to the console.*/


# import numpy as np
# from Bayes_learning import Bayes_Learning
# from Bayes_testing import Bayes_Testing

# # Load data
# training_data = np.loadtxt('train.txt')
# validation_data = np.loadtxt('validate.txt')
# test_data = np.loadtxt('test.txt')

# # Call Bayes Learning to get learned parameters and best priors
# p1, p2, pc1, pc2, error_rates = Bayes_Learning(training_data, validation_data)

# # Print error rate table
# print("Error Rates:")
# print("σ\tError Rate")
# for i, sigma in enumerate([0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 2, 3, 4, 5, 6]):
#     print(f"{sigma}\t{error_rates[i]}")

# # Call Bayes Testing to get error rate on test data
# test_error_rate = Bayes_Testing(test_data, p1, p2, pc1, pc2)
# print(f"Error rate on test data: {test_error_rate}")




#This script should print a table of error rates for each prior on the validation set, and the error rate using the best prior on the test set.

import numpy as np


# Load the data
train_data = np.loadtxt('training_data.txt')
val_data = np.loadtxt('validation_data.txt')
test_data = np.loadtxt('testing_data.txt')



# Separate the classes
train_class0 = train_data[train_data[:, -1] == 0][:, :-1]
train_class1 = train_data[train_data[:, -1] == 1][:, :-1]

# Calculate the maximum likelihood estimate of the parameters
theta_class0 = np.mean(train_class0, axis=0)
theta_class1 = np.mean(train_class1, axis=0)

# Replace 0 probabilities with a small value to avoid numerical problems
theta_class0[theta_class0 == 0] = 1e-10
theta_class1[theta_class1 == 0] = 1e-10

# Define the prior function
def prior(sigma):
    return 1 - np.exp(-sigma)

# Classify the samples in the validation set for different sigma values
sigma_values = [0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 2, 3, 4, 5, 6]

errors = []
for sigma in sigma_values:
    prior_class0 = prior(sigma)
    prior_class1 = 1 - prior_class0

    # Calculate the probability of each class for each sample
    prob_class0 = np.sum(np.log(np.where(val_data[:, :-1] == 1, theta_class0, 1 - theta_class0)), axis=1) + np.log(prior_class0)
    prob_class1 = np.sum(np.log(np.where(val_data[:, :-1] == 1, theta_class1, 1 - theta_class1)), axis=1) + np.log(prior_class1)
    

    # Classify the sample according to the highest probability
    val_class = np.argmax(np.column_stack((prob_class0, prob_class1)), axis=1)

    # Calculate the error rate
    error_rate = np.sum(val_class != val_data[:, -1]) / len(val_data)
    errors.append(error_rate)

# Choose the best prior
best_prior_index = np.argmin(errors)
best_prior = sigma_values[best_prior_index]

# Classify the samples in the test set using the best prior
prior_class0 = prior(best_prior)
prior_class1 = 1 - prior_class0

# Print a table of error rates for all priors
print("Prior Value\tError Rate")
for i in range(len(sigma_values)):
    print("{:.6f}\t\t{:.6f}".format(sigma_values[i], errors[i]))

print(f"Best Prior 1: {prior_class0}")
print(f"Best Prior 2: {prior_class1}")

####################################3
# prob_class0 = np.prod(np.bernoulli.pmf(test_data[:, :-1], theta_class0), axis=1) * prior_class0
# prob_class1 = np.prod(np.bernoulli.pmf(test_data[:, :-1], theta_class1), axis=1) * prior_class1

# test_class = np.argmax(np.column_stack((prob_class0, prob_class1)), axis=1)

# # Calculate the error rate on the test set using the best prior
# test_error_rate = np.sum(test_class != test_data[:, -1]) / len(test_data)

# # Print the table of error rates
# print("Validation set error rates:")
# for i in range(len(sigma_values)):
#     print(f"Sigma={sigma_values[i]:.5f}: {errors[i]*100:.2f}%")

# print(f"\nBest prior: Sigma={best_prior:.5f}")
# print(f"Test set error rate using the best prior: {test_error_rate*100:.2f}%")
