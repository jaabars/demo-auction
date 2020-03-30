package kg.megacom.demoauction.mappers;

import kg.megacom.demoauction.model.dto.*;
import kg.megacom.demoauction.model.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClassMapper {
    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);
    BidDto bidToBidDto (Bid bid);
    Bid bidDtoToBid (BidDto bidDto);
    List<BidDto> bidListToBidDtoList(List<Bid> bidList);
    CustomerDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomerDto(CustomerDto customerDto);
    List<CustomerDto> customerListToCustomerDtoList(List<Customer> customerList);
    LotDto lotToLotDto(Lot lot);
    Lot lotDtoTLot(LotDto lotDto);
    List<LotDto> lotListToLotDto(List<Lot> lotList);
    StatusDto statusToStatusDto(Status status);
    Status statusDtoToStatus(StatusDto statusDto);
    List<StatusDto> statusListToStatusDtoList(List<Status> statusList);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    List<UserDto> userListToUserDtoList(List<User> userList);

}
