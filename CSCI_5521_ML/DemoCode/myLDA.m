
function [V D] = myLDA(Input,Target)

% Determine size of input data
[n m] = size(Input);

% Discover and count unique class labels
ClassLabel = unique(Target);
k = length(ClassLabel);

% Initialize
nGroup     = NaN(k,1);     % Group counts
GroupMean  = NaN(k,m);     % Group sample means
BCov = zeros(m,m);         
allmean = mean (Input);
PooledCov  = zeros(m,m);   % Pooled covariance
W          = NaN(k,m+1);   % model coefficients

% Loop over classes to perform intermediate calculations
for i = 1:k,
    % Establish location and size of each class
    Group      = (Target == ClassLabel(i));
    nGroup(i)  = sum(double(Group));
    
    % Calculate group mean vectors
    GroupMean(i,:) = mean(Input(Group,:));
    
    BCov = BCov + nGroup(i) * (GroupMean(i,:) - allmean)' * (GroupMean (i,:) - allmean);
    
    % Accumulate pooled covariance information
    PooledCov = PooledCov + ((nGroup(i) - 1) / (n - k) ).* cov(Input(Group,:));
end

S = PooledCov^-1 * cov(GroupMean);
[V,D] = eigs(S,m,'lm');



