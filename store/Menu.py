from sqlalchemy.ext.declarative import declarative_base 
from sqlalchemy import Column, String, Integer, event, Float, Boolean
from datetime import datetime

import util

Base = declarative_base()

class Menu(Base):
    __tablename__ = 'Menu_table'
    id = Column(Integer, primary_key=True)

    def __init__(self):
        self.id = None

@event.listens_for(Menu, 'after_insert')
def PostPersist(mapper, connection, target):

    

