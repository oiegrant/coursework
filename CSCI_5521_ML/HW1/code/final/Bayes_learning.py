import numpy as np

def Bayes_Learning(training_data, validation_data):
    """
    Function to perform Bayes learning on the given training data and validation data.
    
    Parameters:
        training_data (numpy array): A 2D numpy array containing the training data
                                     where each row corresponds to a data point and
                                     each column corresponds to a feature.
        validation_data (numpy array): A 2D numpy array containing the validation data
                                       where each row corresponds to a data point and
                                       each column corresponds to a feature.
    Returns:
        p1 (numpy array): A 1D numpy array containing the learned Bernoulli parameters
                          of the first class.
        p2 (numpy array): A 1D numpy array containing the learned Bernoulli parameters
                          of the second class.
        pc1 (float): The best prior of the first class.
        pc2 (float): The best prior of the second class.
    """
    # Separate the training data into two classes 1/2
    class_1_data = training_data[training_data[:, -1] == 1, :-1]
    class_2_data = training_data[training_data[:, -1] == 2, :-1]

    
    # Calculate the MLE / learned Bernoulli parameters for each CLASS
    p1 = np.mean(class_1_data, axis=0)
    p2 = np.mean(class_2_data, axis=0)

    # Replace 0 probabilities with a small value to avoid numerical problems
    # DOUBLE CHECK THIS ISNT class_1_data
    p1[p1 == 0] = 1e-10
    p2[p2 == 0] = 1e-10
    
    # Calculate the error rate for each possible prior value on the validation data
    sigma_values = [0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 2, 3, 4, 5, 6]
    error_rates = []

    # Define the prior function
    def prior(sigma):
        return 1 - np.exp(-sigma)


    for sigma in sigma_values:
        # Calculate the prior probabilities of each class
        pc1 = prior(sigma)
        pc2 = 1 - pc1
        
        # Calculate the posterior probabilities for each data point in the validation data

        posteriors = np.zeros((validation_data.shape[0], 2))        
        
        posteriors[:, 0] = np.sum(np.log(np.where(validation_data[:, :-1] == 1, p1, 1 - p1)), axis=1) + np.log(pc1)
        # posteriors[:, 0] = np.prod(validation_data[:, :-1] * np.log(p1) + (1 - validation_data[:, :-1]) * np.log(1 - p1), axis=1) + np.log(pc1)
        posteriors[:, 1] = np.sum(np.log(np.where(validation_data[:, :-1] == 1, p2, 1 - p2)), axis=1) + np.log(pc2)
        # posteriors[:, 1] = np.prod(validation_data[:, :-1] * np.log(p2) + (1 - validation_data[:, :-1]) * np.log(1 - p2), axis=1) + np.log(pc2)

        
        # Classify the validation data using the maximum posterior probability
        classifications = np.argmax(posteriors, axis=1) + 1
        
        # Calculate the error rate
        error_rate = np.mean(classifications != validation_data[:, -1])
        error_rates.append(error_rate)
    
    # Find the best prior that gives the lowest error rate on the validation data
    best_sigma = sigma_values[np.argmin(error_rates)]
    pc1 = prior(best_sigma)
    pc2 = 1 - pc1
    
    # Print a table of error rates for all priors
    print("Prior Value\tError Rate")
    for i in range(len(sigma_values)):
        print("{:.6f}\t\t{:.6f}".format(sigma_values[i], error_rates[i]))
    
    return p1, p2, pc1, pc2