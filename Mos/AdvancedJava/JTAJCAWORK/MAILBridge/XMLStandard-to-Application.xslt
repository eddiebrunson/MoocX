<?xml version="1.0" encoding="UTF-8"?>
<!--
This file was generated by Altova MapForce 2008

YOU SHOULD NOT MODIFY THIS FILE, BECAUSE IT WILL BE
OVERWRITTEN WHEN YOU RE-RUN CODE GENERATION.

Refer to the Altova MapForce Documentation for further details.
http://www.altova.com/mapforce
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:standard="http://e-commerceANDm-commerce/ShoppingStandards" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://org.mk.traininggmail.com/MessageDefinitions" xmlns:res="http://service.existing.training.mk.org/" exclude-result-prefixes="standard tns xs">
	<xsl:output method="xml" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/tns:requestOrder">
		<res:processOrder>
			<arg0 xmlns="">
				<xsl:for-each select="standard:CreditCard">
					<card>
						<xsl:for-each select="Amount">
							<amount>
								<xsl:value-of select="."/>
							</amount>
						</xsl:for-each>
						<xsl:for-each select="DateOfPurchase">
							<dateOfPurchase>
								<xsl:value-of select="."/>
							</dateOfPurchase>
						</xsl:for-each>
						<xsl:for-each select="ExpiryDate">
							<expiryDate>
								<xsl:value-of select="."/>
							</expiryDate>
						</xsl:for-each>
						<xsl:for-each select="Name">
							<name>
								<xsl:value-of select="."/>
							</name>
						</xsl:for-each>
						<xsl:for-each select="Number">
							<number>
								<xsl:value-of select="."/>
							</number>
						</xsl:for-each>
						<xsl:for-each select="Type">
							<type>
								<xsl:value-of select="."/>
							</type>
						</xsl:for-each>
					</card>
				</xsl:for-each>
				<xsl:for-each select="CustomerNumber">
					<customerId>
						<xsl:value-of select="."/>
					</customerId>
				</xsl:for-each>
				<xsl:for-each select="standard:Cart">
					<xsl:for-each select="Item">
						<products>
							<xsl:for-each select="Description">
								<description>
									<xsl:value-of select="."/>
								</description>
							</xsl:for-each>
							<xsl:for-each select="ItemNumber">
								<itemNumber>
									<xsl:value-of select="."/>
								</itemNumber>
							</xsl:for-each>
							<xsl:for-each select="Name">
								<name>
									<xsl:value-of select="."/>
								</name>
							</xsl:for-each>
							<xsl:for-each select="PricePerUnit">
								<pricePerUnit>
									<xsl:value-of select="."/>
								</pricePerUnit>
							</xsl:for-each>
							<xsl:for-each select="Quantity">
								<quantity>
									<xsl:value-of select="."/>
								</quantity>
							</xsl:for-each>
						</products>
					</xsl:for-each>
				</xsl:for-each>
				<xsl:for-each select="PurchaseOrderNumber">
					<purchaseOrderNumber>
						<xsl:value-of select="."/>
					</purchaseOrderNumber>
				</xsl:for-each>
			</arg0>
		</res:processOrder>
	</xsl:template>
</xsl:stylesheet>