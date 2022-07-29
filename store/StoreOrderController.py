from flask import Flask, abort, jsonify, request, Blueprint, Response
import StoreOrderRepository 
import Hateoas 

bp = Blueprint('storeOrder', __name__, url_prefix='/storeOrders')

@bp.route("", methods=["POST"])
def Post():
    response = StoreOrderRepository.Create(request)

    response = Hateoas.POST_response(request.base_url, response)
    return response

@bp.route("", methods=["GET"])
def Get():
    response = StoreOrderRepository.Read(request)
    response = Hateoas.GET_list_response(request.url_root, request.base_url, response)
    
    return response

@bp.route("/<int:id>", methods=["GET"])
def Get_By_Id(id: int):
    response = StoreOrderRepository.Read_by_id(id)

    if response != 'error':
        response = Hateoas.GET_id_response(request.base_url, response)
    else:
        response = Response(response, status=404,mimetype='application/json')
    return response

@bp.route("/<int:id>", methods=["UPDATE"])
def Update(id: int):
    
    response = StoreOrderRepository.Update(id, request)
    
    if response != 'error':
        response = Hateoas.GET_id_response(request.base_url, response)
    else:
        response = Response(response, status=403,mimetype='application/json')

    
    return response

@bp.route("/<int:id>", methods=["DELETE"])
def Delete(id: int):
    response = StoreOrderRepository.Delete(id)
    if response == None:
        response = Response(status=200, mimetype='application/json')
    else :
        response = Response(response, status=403,mimetype='application/json')
    
    return response

@bp.route("/finish-cook", methods=["PUT"])
def finishCook(): # -> 이부분 수정 
    
    '''
    LOGIC GOES HERE
    '''
    return 'hello world!'

@bp.route("/accept", methods=["PUT"])
def accept(): # -> 이부분 수정 
    
    '''
    LOGIC GOES HERE
    '''
    return 'hello world!'

@bp.route("/reject", methods=["PUT"])
def reject(): # -> 이부분 수정 
    
    '''
    LOGIC GOES HERE
    '''
    return 'hello world!'

@bp.route("/start-cook", methods=["PUT"])
def startCook(): # -> 이부분 수정 
    
    '''
    LOGIC GOES HERE
    '''
    return 'hello world!'


@bp.errorhandler(404)
def resource_not_found(e):
    return jsonify(error=str(e)), 404
