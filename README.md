# README #

This repository is for the Group 10 coursework of the COM3014 module.

### How do I get set up? ###

To start from scratch: 


Go to your IDE and create a new project by cloning the git repo.

* git clone https://noctesidus@bitbucket.org/springprojectcom3014/courseworkcom3014.git

Once you have succesfully cloned the repo to build and run the project you need to run the following commands in the terminal while at the project's directory.

1. mvn clean install

2. mvn test tomcat7:run

***

# Prequisites of Dataset Engineering #

The dataset that we will be using can be found at the following url:  [Link to Dataset](https://github.com/ageron/handson-ml/tree/master/datasets/housing)

This dataset is a result of a couple of tweaks from an original dataset (source of prior dataset: [Link to Original Dataset](http://www.dcc.fc.up.pt/~ltorgo/Regression/cal_housing.html). The tweaks include adding a new feature to each instance
of the dataset to include it's ocean proximity. Furthermore a few instances have also been removed. (More info can be found at the above urls)

### Fetching the dataset ###

```python
import os
import tarfile
import pandas as pd
from six.moves import urllib

DOWNLOAD_ROOT = "https://raw.githubusercontent.com/ageron/handson-ml/master/"
HOUSING_PATH = "datasets/housing"
HOUSING_URL = DOWNLOAD_ROOT + HOUSING_PATH + "/housing.tgz"

def fetch_housing_data(housing_url=HOUSING_URL, housing_path=HOUSING_PATH):
    if not os.path.isdir(housing_path):
        os.makedirs(housing_path)
    tgz_path = os.path.join(housing_path, "housing.tgz")
    urllib.request.urlretrieve(housing_url, tgz_path)
    housing_tgz = tarfile.open(tgz_path)
    housing_tgz.extractall(path=housing_path)
    housing_tgz.close()

def load_housing_data(housing_path=HOUSING_PATH):
    csv_path = os.path.join(housing_path, "housing.csv")
    return pd.read_csv(csv_path)


fetch_housing_data()
housing = load_housing_data()


```

To inspect the dataset that has been fetched you can run the following scripts to inspect it.

```python
housing.head()
```
OR

```python
housing.info()
```
OR

```python
housing.describe()
```

A few notes about the dataset so far:

1. There are 20640 instances in the dataset.
2. The total_bedrooms attribute has only 20433 non-null values, meaning that 207 districs are missing this feature.
3. All attributes are numerical, except for the ocean_proximity field.


## Dataset Exploration ##

A quick way to have a look at the dataset and have a better feel of it is to plot a histogram for each numerical figure.

![Histogram](https://image.ibb.co/dHdoYG/histogram.png)

A couple of things to note:

1. The median_income attribute seems a bit off. Furthermore this attribute has been scaled and capped at 15 for higher median incomes and at 0.5 for lower median incomes.
2. The housing_median_age and the median_house_value attributes have also been capped.

### Looking at the data geographically ###

A Density Map:

![DensityMap](https://image.ibb.co/kRWmVw/density_Map.png)

An enhanced look at the map. The radius of each circle represents the district's population and the colour represents the price.
![EnhancedMap](https://image.ibb.co/cEbBVw/Screen_Shot_2017_11_14_at_17_51_59.png)

The above maps show us where some clusters could be and that higher house prices seem to have a correlation between there proximity to the ocean.

## Looking for correlations ##

### Pearsons' r ###
Since the dataset is quite large it would be ideal to look for correlations using the standard correlation coefficient (Pearson's r)
between every pair of attributes since it is relatively easy to compute.

![correlations](https://image.ibb.co/ffcz0w/correlations.jpg)

The correlation coefficient ranges from -1 to 1. When it is close to 1, it means that there is a strong positive correlation; for example,
the median house value tends to go up when the median income goes up. When the coefficient is close to -1, it means that there is a strong negative
correlation. Finally, coefficients close to zero mean that there is no linear correlation.

### Scatter matrix ###

We can also look for correlations using Pandas which is a python library and provides a scatter_matrix function. Since we have 11 numerical attributes this method
would produce 121 plots. (Not all plots are shown for brevity.)

A point of intrest in the following plots is the median income versus median house value.

![scatterMatrix](https://image.ibb.co/mYVjoR/scatter.png)

The correlation between these two attributes seems to be strong, there is a strong indication of an upward trend and the points aren't too
dispersed. Furthermore the cap at $500,000 seems evident but also some other patterns have been revealed at around $450,000, $350,000 and more.

![scatterDetail](https://image.ibb.co/e6jadR/scatter_Detail.png)

## Experimenting with Attribute Combinations ##

Some of the attributes that we have explored don't seem to correlate well with others. Some attributes could be combined to improve accuracy and possibly increase performance.
For example the total number of rooms in a distric is not very useful if you don't know how many households there are. 

We could try creating a new attribute such as the number of rooms per household and similarly a population per household attribute and see how well they correlate with the other existing attributes.

Example of how these new attributes correlate with others:

![newCorrelationsPR](https://image.ibb.co/d9Zmk6/newcorr.png | width=225)

It seems that our new attribute, rooms_per_household, has a slight positive correlation wih our median_house_value. While on the other hand our other new attribute, population_per_household,
seems to have a negative correlation with the median_house_value. 

Using the new attribute, rooms_per_household, we can change the dataset that we will use to train the model and instead use the new attribute that is produced by
the above findings which could yield a better accuracy and a better performing model.


## Preparing for Machine Learning Algorithms ##


###  Data Cleaning ###

As previously mentioned some instances contain sparse data and as such this data needs to be dealt with.

There are many ways to deal with this problem, one could delete all such occuring instances, remove a whole attribute from the dataset or
set the values to some value (zero, mean, etc.).

For this project I'm going to set any missing values to the median value of that attribute.

### Handling Text/Categorical Attributes ###

Since Machine Learning Algorithms are more proficient at working with numbers then any text or categorical attributes. It would be wise to then 
convert any such instances into an appropriate numerical representation.