# OOP-2021
Môn học Lập trình hướng đối tượng với Java
**Khác nhau** <br/>
*Observations*
+ DDD architechture lập mô hình dựa trên thực tế liên quan tới usecase
+ DDD sử dụng API cho các entity <br/>
+ export class Job extends AggregateRoot<JobProps> {
  ...
  get paymentType (): PaymentType {
    return this.props.paymentType;
  }

  // No setter exposed

  public updatePaymentType (paymentType: PaymentType): Result<void> {
    if (this.hasApplicants()) {
      return Result.fail<void>(
        `Can't update payment type 
        on a job that has applicants`
      )
    } else {
      this.props.paymentType = paymentType;
      return Result.ok<void>();
    }
  }
}
*Domain service*
+ DDD sử dụng domain service <br/>
class PostService {

  ...

  /**
   * Demonstrating the use of a domain service to
   * encapsulate domain logic that involves several
   * entities.
   */

  public upvotePost (
    post: Post, 
    member: Member, 
    existingVotesOnPostByMember: PostVote[]
  ): UpvotePostResponse {

    const existingUpvote: PostVote = existingVotesOnPostByMember
      .find((v) => v.isUpvote());

    // If already upvoted, do nothing
    const upvoteAlreadyExists = !!existingUpvote;

    if (upvoteAlreadyExists) {
      return right(Result.ok<void>());
    } 

    // If downvoted, remove the downvote
    const existingDownvote: PostVote = existingVotesOnPostByMember
    .find((v) => v.isDownvote());

    const downvoteAlreadyExists = !!existingDownvote;

    if (downvoteAlreadyExists) {
      post.removeVote(existingDownvote);
      return right(Result.ok<void>());
    }

    // Otherwise, add upvote
    const upvoteOrError = PostVote
      .createUpvote(member.memberId, post.postId);

    if (upvoteOrError.isFailure) {
      return left(upvoteOrError);
    }

    const upvote: PostVote = upvoteOrError.getValue();
    post.addVote(upvote);

    return right(Result.ok<void>());
  }
  ...
}
  *Application Services*
+ DDD trong Application layer sử dụng Applycation service
  - và các standard form là thiên về usecase
  try {
      
      // Get the member
      try {
        member = await this.memberRepo.getMemberByUserId(req.userId);
      } catch (err) {
        return left(new UpvotePostErrors.MemberNotFoundError())
      }

      // Get the post
      try {
        post = await this.postRepo.getPostBySlug(req.slug);
      } catch (err) {
        return left(new UpvotePostErrors.PostNotFoundError(req.slug));
      }

      // Get the existing post votes
      existingVotesOnPostByMember = await this.postVotesRepo
        .getVotesForPostByMemberId(post.postId,  member.memberId);

      // Allow the domain service to exec
      const upvotePostResult = this.postService
        .upvotePost(post, member, existingVotesOnPostByMember);

      // If failed, return a failure result
      if (upvotePostResult.isLeft()) {
        return left(upvotePostResult.value);
      }

      // Otherwise, commit the transaction
      await this.postRepo.save(post);

      // Success!
      return right(Result.ok<void>())

    } catch (err) {
      return left(new AppError.UnexpectedError(err));
    } <br/>
**Giống nhau** <br/>
+ Có Layer: Domain
+ 
