import numpy as np

def Bayes_Testing(test_data, p1, p2, pc1, pc2):
    """
    Classifies the samples in the test set using the learned Bernoulli distributions and given priors.
    Returns the error rate of classification.
    
    Args:
    test_data (ndarray): A 2D numpy array of shape (N, M) where N is the number of samples and M is the number of features.
    p1 (ndarray): A 1D numpy array of shape (M,) representing the learned Bernoulli parameters of class 1.
    p2 (ndarray): A 1D numpy array of shape (M,) representing the learned Bernoulli parameters of class 2.
    pc1 (float): The best prior of class 1.
    pc2 (float): The best prior of class 2.
    
    Returns:
    float: The error rate of classification.
    """
    # Calculate the error rate on the test set using the best prior
    class_probs = np.zeros((test_data.shape[0], 2))
    class_probs[:, 0] = np.sum(np.log(np.where(test_data[:, :-1] == 1, p1, 1 - p1)), axis=1) + np.log(pc1)
    class_probs[:, 1] = np.sum(np.log(np.where(test_data[:, :-1] == 1, p2, 1 - p2)), axis=1) + np.log(pc2) 
    predictions = np.argmax(class_probs, axis=1) + 1
    error_rate = 1 - np.mean(predictions == test_data[:, -1])
    return error_rate