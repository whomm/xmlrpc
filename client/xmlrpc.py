import xmlrpclib

s = xmlrpclib.ServerProxy('http://127.0.0.1:10080')
mytest="test string"
print s.Handler.doRun(mytest)
