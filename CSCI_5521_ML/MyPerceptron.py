import matplotlib.pyplot as plt
import numpy as np

def MyPerceptron(X, y, w0):
    err = 1
    round = 0
    w = w0

    mxx = max(X[:,0])
    mnx = min(X[:,0])
    mxy = max(X[:,1])
    mny = min(X[:,1])

    while err > 0:
        for i in range(len(X)):
            if (np.dot(X[i],w)*y[i]) <= 0:
                w = w + (y[i] * X[i])
                x1 = np.arange(mnx,mxx,0.01)
                x2 = -(w[0]*x1 + w[1])/w[1]
                plt.clf()
                plt.scatter(X[:, 0], X[:, 1],c=y)
                plt.plot(x1,x2,'y-')
                plt.xlim([mnx,mxx])
                plt.ylim([mny,mxy])


        round += 1
        err = np.sum(np.sign(np.dot(X,w.T)) != y) / len(y)

    return w, round
                
MyPerceptron(X,y,w_init)    
