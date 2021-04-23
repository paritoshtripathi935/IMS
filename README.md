# inventary-managment-system---moon
this is the repository for the inventory management system made by the team moon
At the end of their day, cooks and managers in the cafeteria industry spend a couple of hours counting inventory and placing orders for the following week. The Cafeteria Inventory Management System is designed to not only assist in this problem.

But also automate many of the tedious tasks associated with it. The system keeps track of current inventory levels for recipes at the ingredient level, predicts how much inventory is needed for the upcoming week, and generates order forms to that can be automatically sent to vendors.

After meeting with a cook for The Classic Cafeteria, an on-site commercial cafeteria management company, we were easily able to identify issues in the maintenance of resource prerequisite lists.

To keep track of their inventory levels, staff had to calculate a list of groceries utilized during a course of time, calculate, and analyse the requirements for the upcoming weeks, and place their next order to multiple vendors if needed.

This process takes up a lot of time and human effort, and is also inclined to human error.

It became our main goal to develop a system that can be used by both large corporations as well as small businesses.

This meant the system had to deliver an well-organized and simple user interface that at the same time is capable of more exact changes and inputs. The system had to also be precise and reliable in terms of the database design.

Since all the data and data objects are stored in a database, it was authoritative that these requirements were met.

Inventories contains most part of current assets of any big company. Managing these inventories is always hectic work for the manager. For good production and customer satisfaction, we need a good Inventory Management system. 

You can also check these posts:

Medical Management System
Online Shopping Project
Online Shopping System
Courier Management System
Stock Management System Project
OBJECTIVES AND SUCCESS CRITERIA OF Inventory Management System
The objective of the project is to deliver an efficient inventory management system whose main functionality apart from calculating the inventory include predicting the requirement for the next demand and if there is a “Special Occasion” then accordingly the manager selects the particular occasion and extra requirements is added to the next issuing order to the vendors which needs to be approved by the manager.

The product also aims to keep track of the shelf life of resources. If any resource nears the end of its shelf life, it would acknowledge to the manager (admin) the details of the quantity that is near its expiration date.

The success criteria depend on

The accuracy in keeping the inventory levels
The accuracy in predicting the requirements of the next demand
The accuracy in relating recipes to their respective constituents
Ease of use when it comes to updating inventory levels and placing orders to vendors
Purpose of Inventory Management System Project
The Inventory Management System is a real-time inventory database capable of connecting multiple stores.  This can be used to track the inventory of a single store, or to manage the delivery of stock between several branches of a larger franchise.

However, the system merely records sales and restocking data and provides warning of low stock at any location through email at a specified interval.  The goal is to reduce the stress of tracking rather than to holder all store maintenance.

Further features may consist of the ability to create reports of sales, but again the explanation is left to the management.  In addition, since theft does occasionally occur, the system provides solutions for confirming the store inventory and for correcting stock quantities.

Production unit use inventory management system to reduce their transport costs. The system is used to track products and parts as they are transported from a seller to a storeroom, between storerooms, and finally to a retail location or directly to a customer. Inventory management system is used for various purposes,

including:

Maintaining and recording the information between too much and too little inventory in company.
Keep track of inventories as it is transported between different locations.
Recording products information in a warehouse or other location.
Having record of Picking, packing, and selling products from a warehouse.
Reduction of product obsolescence and decay.
Avoiding the out-of-stock situations.
Existing System
There are number of Inventory Management System available in the market. After doing my research, I have come to know that most of them are limited to few products. Some others are lacking in good UI.

Marketing points are not much focus to increasing sales. Customer management system and Inventory Management system can’t be linked due to different organization which leads to compromising the client satisfaction level.

Most of them are not using cloud computer concept but we are trying to develop such a system which is for everyone rather than for only big companies or for small organisation. Most of them are expensive to use and their maintenance is generally not cheap. Our system is Pay-as-per-Use.   

E-R Diagram of Inventory Management System Project
Inventory Management System

Once the planning and analysis of project is Done, the design phase begins. Goal of system design is to transform the information collected about project into the blueprint structure which will serve as a base while constructing the system.

It is unwieldy process as most of errors are introduce in this phase. However, if error gets unnoticed in later process it may become difficult to track them down.

The following entity relationship diagram shows the graphical view of required components of the system.               

Properties:
Admin:
Primarily, user which will interact the system will be the administrator of institution assign to take care of all data transaction and insertion or update. It will have to go through an authorization process of login and logout. It will have ability to create storage record, add inventory details, item details, Orders, Shipment details and take care of development and maintenance of application

Name: Name of Admin
AdminID: It will be a unique value which will act as the primary key and will be same as employee id in the company.
EmailID: For contacting purpose every user must enter their email id.
Address: Employee address is also an attribute which help to get more about employee.
Manager:
Secondary, user which will interact the system will be the Manager of institution assign to take care of management services. It will have to go through an authorization process of login and logout.

It will have ability to create storage record, add inventory details, item details, Orders, Shipment details and take care of notification and can see reports and other business related data.

Name: Name of Manager
EmpID: It will be a unique value which will act as the primary key.
EmailID: For contacting purpose every user must enter their email id.
Address: Employee address is also an attribute which help to get more about employee.
Storage:
Storage is used to store raw material and product that has been produced but not being order.

Sno: Serial number is assign to every product or raw material to keep their records. It is Primary key.
Bar_Code: To make record update process faster. We have added bar code system which would help to update status of product just after a scan using bar code reader.
Name: Name of product or raw materials.
Inventory:
Inventory is basically having records of items and their quality. It has following attributes.

InventoryID: Inventory Id is primary key to identify each record.
ItemID: We have already Items table in our Database. Here ItemID is foreign key to that table.
Quantity: Quantity describe the number of unit available or amount of product or material available.
Items:
Item is actual product we produce in our company. It has following Attributes. 

ItemNo: Item number is numeric data assign to every product. This is unique for every product. That means this Primary key.
Bar Code: ItemNo is converted into bar code and updated in barcode field. This would increase the process of tracking and getting actual information.
Item_discription: This attribute basically keep the record of every information about product.   
Orders:
Whenever an order is received from customer. It fetches the item from the item table and tag OrderNo. To it. It has following attributes.

OrderNo: This is primary key to Order table. It uniquely identifies every record of this table.
Barcode: Every orderNo is convert to bar code and tag to product and barcode is generate and pasted over product. This will help to track the product.
Date Required: This is attribute store the information of dead line of product.
Date Completed: When product is delivered to client. Date should be updated and payment clearance should to noted.
Shipments:
When product is successfully ordered. Its time ship the product. It contains following attributes.

ShipmentNo: This is primary key for Shipment table. It uniquely defines every shipment.
Address: Address is mandatory field without this field data would not be save in database.
Shipment Date: When data is successfully shipped date of that day would updated to our database.
UI DESIGN of Inventory Management System Project
UI plays major role in success of any software. Simple, user friendly and standard UI makes visitors experience great and which means software is going to be successful.

Sometimes very smooth and having very good database design software can’t able to make their existence in market because of it UI.

The Inventory Management System hassles out all the complication of conventional method which is combination of the interaction to human.

Each profile has its own UI which is customized by our experienced team to make them feel like they are special.

We have developed very simple, User friendly UI with all standardization. Followings are the interfaces

Login Page: Basically, for any software security is major concern. So, we have developed a secure application. Without being authenticated no user is allow to view any other interfaces. For login page we have User ID, Password, Profile. After being authenticated user is authorize to perform certain work according to his/her profile.
Profile Page: Every user has his own profile. From here they can change their information like correction in name, email id, address etc.
Storage Page: In this page users can add items to be stored using this page and barcode reader. After scanning barcode information that stored in barcode are fetch from database and desired data are stored in storage table.
Inventory Page: Inventory page provides flexibility to change quality if any inventory get damaged. Managing inventory is our main goal so this page is only visible to admin or manager profiles.
Items Page: User can add new items using this page. While adding the items to database user provide item description. This description help to understand the quality of product, uses, manufacture date, expiry date etc.
Order Page: Using order page one can place order and database would add the item to order list and quantity has been decrease from Inventory table. Admin/Manager has special privilege to edit order details if customer requested to edit them. Order is attached to shipment table which help the user to get the address of customer and make order to dispatch.
Shipment page: Using this page user can update address, if it changes and track the shipped items. Tracking is required to increase the client experience more satisfactory. This page also help the user to cancel any product if customers demand such things.
Workflow & Automation Logic:
Now a day, Automation is demand in any business. As per requirement of era, we come up with some solution.

Reordering of Inventory:
Inventory reaches a specific threshold; our Inventory Management System can be programmed to tell managers to reorder that product.

This helps companies avoid running out of products or tying up too much capital in inventory. This is very good feature and add extra advantages to our system. Due to less involvement of human chances of error has been reduced exponentially.

Asset Tracking:
Inventory is current asset for any company to tracking the asset is mandatory.

When a item is in a warehouse, it can be tracked via its barcode or some other ways like serial number, lot number or revision number.

This will help the user and company to track his net worth very clearly. This makes calculation of net profit and loss more quickly than previous.

Email notification:
Whenever customer books any order in our company an email alert has been sent to him/her as confirmation and tracking id and email notification of their order status send to them periodically.

Service Management:
Companies that are basically service-oriented rather than product-oriented can use inventory management system to track the cost of the materials they use to deliver facilities, such as cleaning supplies.

This way, they can attribute prices to their services that reflect the total cost of executing them.

Barcode:
Due to use of barcode process of tracking the product becomes easier. Barcodes are often the means whereby data on products and orders is entered inventory management system.

A barcode reader is used to read barcodes and look up info on the products they represent. Radio-frequency identification (RFID) tags and wireless methods of product identification are also growing in fame.

Advantages of inventory management system project
There are many advantages of inventory management system. Thus, summarized below which can avoid the company from suffering from big economical loss and other problems that may occur during the everyday operations of the firm that can be observed as the materials being out of stock or machine failures and many other operations happening on day-to-day basis.

There are several Advantages of using the inventory management in a business setting are:
Cost savings: In many cases companies inventory is one of the major investments along with its employees and locations. inventory management system helps the companies to cut the expenses by minimizing the amount of needless products and materials in storage. It also helps companies keep lost sales to a minimum by having enough stock to meet demand.
Increased efficiency: The inventory management system allows for may automated inventory task for example the system can automatically collect data, calculate costs. This also reduces in costs saving and time saving and thus subsequently leading to increase in business proficiency.
Warehouse organization: Inventory management system help distributors, wholesalers, manufacturers, and retailers adjust their warehouses. If certain products are often sold together or are more popular than others, those products can be grouped together or placed near the delivery area to speed up the process of picking.
Updated data: Provides up to date and real time data on inventory levels is and benefit of inventory management system. Company executives can usually access the software through their mobile devices, laptop for checking current inventory numbers this automatic updating of inventory allows the business to make informed decisions.
Data security: By supplementary with the restricted user rights, company managers can allow many employees to contribution in inventory management. They can grant employees enough data access for tasks such as receiving products, making orders, transfer products and perform other tasks without compromising company security. This can speed up the inventory management process and save managers’ time.
Insight into Trends: This helps tracking the products which are in stock and from which suppliers do they come from and the length of the time they are deposited is made possible with inventory management system by analysing this data the company can improve their inventory levels and maximize the use of storeroom space. Additionally, firms are more prepared for the demands and supplies of the market, especially during special situations such as a peak season on a particular month.
