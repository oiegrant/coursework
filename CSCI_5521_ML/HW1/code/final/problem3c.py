import numpy as np

# Define parameters
D = 2
p11 = 0.6
p12 = 0.1
p21 = 0.6
p22 = 0.9

# Define priors
priors = [0.2, 0.6, 0.8]

# Define function for calculating log probabilities
def log_prob(x, c, priors):
    # Calculate log likelihoods
    log_l1 = np.sum((1 - np.array([p11, p12]) * x) * np.log(1 - np.array([p11, p12]) * x) + np.array([p11, p12]) * x * np.log(np.array([p11, p12]) * x))
    log_l2 = np.sum((1 - np.array([p21, p22]) * x) * np.log(1 - np.array([p21, p22]) * x) + np.array([p21, p22]) * x * np.log(np.array([p21, p22]) * x))
    
    # Calculate log priors
    log_p1 = np.log(priors[0])
    log_p2 = np.log(1 - priors[0])
    
    if c == 1:
        # Calculate log posterior probability for C1
        log_post = log_p1 + log_l1 - np.logaddexp(log_p1 + log_l1, log_p2 + log_l2)
    else:
        # Calculate log posterior probability for C2
        log_post = log_p2 + log_l2 - np.logaddexp(log_p1 + log_l1, log_p2 + log_l2)
    
    # Return the exponentiated log posterior probability
    return np.exp(log_post)

# Calculate posterior probabilities for all possible samples
samples = [(0, 0), (0, 1), (1, 0), (1, 1)]

for prior in priors:
    print(f"Priors: P(C1) = {prior}, P(C2) = {1 - prior}")
    for x in samples:
        p_c1 = log_prob(x, 1, [prior, 1 - prior])
        p_c2 = log_prob(x, 2, [prior, 1 - prior])
        print(f"x = {x}: P(C1|x) = {p_c1}, P(C2|x) = {p_c2}")
