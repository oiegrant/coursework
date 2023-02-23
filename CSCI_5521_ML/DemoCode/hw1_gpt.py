import numpy as np

def Bayes_learning(train_data, val_data):
    # Separate the training set into two classes
    class_1 = train_data[train_data[:, -1] == 1]
    class_2 = train_data[train_data[:, -1] == 2]

    # Calculate the MLE of the Bernoulli parameters for each feature and class
    p1 = np.maximum(np.sum(class_1[:, :-1], axis=0) / class_1.shape[0], 1e-10)
    p2 = np.maximum(np.sum(class_2[:, :-1], axis=0) / class_2.shape[0], 1e-10)

    # Define the range of priors to consider
    priors = [0.00001, 0.0001, 0.001, 0.01, 0.1, 1, 2, 3, 4, 5, 6]
    
    # Calculate the error rate for each prior on the validation set
    error_rates = []
    for pc1 in priors:
        pc2 = 1 - pc1
        class_probs = np.zeros((val_data.shape[0], 2))
        class_probs[:, 0] = np.prod(val_data[:, :-1] * np.log(p1) + (1 - val_data[:, :-1]) * np.log(1 - p1), axis=1) + np.log(pc1)
        class_probs[:, 1] = np.prod(val_data[:, :-1] * np.log(p2) + (1 - val_data[:, :-1]) * np.log(1 - p2), axis=1) + np.log(pc2)
        predictions = np.argmax(class_probs, axis=1) + 1
        error_rate = 1 - np.mean(predictions == val_data[:, -1])
        error_rates.append(error_rate)
        
    # Choose the best prior
    best_prior_idx = np.argmin(error_rates)
    best_pc1 = priors[best_prior_idx]
    best_pc2 = 1 - best_pc1
    
    # Print the error rates for each prior on the validation set
    print("Error rates for each prior on the validation set:")
    print("-------------------------------------------------")
    for i in range(len(priors)):
        print(f"P(C1|g)={priors[i]}: {error_rates[i]:.4f}")
    print()
    
    return p1, p2, best_pc1, best_pc2

def Bayes_testing(test_data, p1, p2, pc1, pc2):
    # Calculate the error rate on the test set using the best prior
    class_probs = np.zeros((test_data.shape[0], 2))
    class_probs[:, 0] = np.prod(test_data[:, :-1] * np.log(p1) + (1 - test_data[:, :-1]) * np.log(1 - p1), axis=1) + np.log(pc1)
    class_probs[:, 1] = np.prod(test_data[:, :-1] * np.log(p2) + (1 - test_data[:, :-1]) * np.log(1 - p2), axis=1) + np.log(pc2)
    predictions = np.argmax(class_probs, axis=1) + 1
    error_rate = 1 - np.mean(predictions == test_data[:, -1])
    print(f'error rate = {error_rate}'  )


training_data = np.loadtxt('training_data.txt')
validation_data = np.loadtxt('validation_data.txt')
test_data = np.loadtxt('testing_data.txt')

p1, p2, best_pc1, best_pc2 = Bayes_learning(training_data,validation_data)

Bayes_testing(test_data,p1, p2, best_pc1, best_pc2)
    
   
